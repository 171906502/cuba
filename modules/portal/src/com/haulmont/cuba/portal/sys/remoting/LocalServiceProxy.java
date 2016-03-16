/*
 * Copyright (c) 2008-2016 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.haulmont.cuba.portal.sys.remoting;

import com.haulmont.cuba.core.global.RemoteException;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.serialization.SerializationSupport;
import com.haulmont.cuba.core.sys.remoting.LocalServiceDirectory;
import com.haulmont.cuba.core.sys.remoting.LocalServiceInvocation;
import com.haulmont.cuba.core.sys.remoting.LocalServiceInvocationResult;
import com.haulmont.cuba.core.sys.remoting.LocalServiceInvoker;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.remoting.support.RemoteAccessor;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 */
public class LocalServiceProxy extends RemoteAccessor implements FactoryBean<Object>, InitializingBean {

    private Object serviceProxy;
    private String serviceName;

    @Override
    public void afterPropertiesSet() {
        if (serviceName == null)
            throw new IllegalStateException("Property 'serviceName' is required");
        if (getServiceInterface() == null)
            throw new IllegalStateException("Property 'serviceInterface' is required");

        serviceProxy = Proxy.newProxyInstance(
                getBeanClassLoader(),
                new Class[]{getServiceInterface()},
                new LocalServiceInvocationHandler(serviceName)
        );
    }

    @Override
    public Object getObject() throws Exception {
        return serviceProxy;
    }

    @Override
    public Class<?> getObjectType() {
        return getServiceInterface();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        if (serviceName.startsWith("/"))
            this.serviceName = serviceName;
        else
            this.serviceName = "/" + serviceName;
    }

    private static class LocalServiceInvocationHandler implements InvocationHandler {

        private String serviceName;

        public LocalServiceInvocationHandler(String serviceName) {
            this.serviceName = serviceName;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String connectionUrlList = AppContext.getProperty("cuba.connectionUrlList");
            if (connectionUrlList == null)
                throw new IllegalStateException("Property cuba.connectionUrlList not defined");

            String entryName = connectionUrlList.substring(connectionUrlList.lastIndexOf('/') + 1) + serviceName;
            LocalServiceInvoker invoker = LocalServiceDirectory.getInvoker(entryName);
            if (invoker == null)
                throw new IllegalArgumentException("Service " + entryName + " is not registered in LocalServiceDirectory");

            Class<?>[] parameterTypes = method.getParameterTypes();
            String[] parameterTypeNames = new String[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                parameterTypeNames[i] = parameterTypes[i].getName();
            }

            byte[][] argumentsData;
            Object[] notSerializableArguments;
            if (args == null) {
                argumentsData = null;
                notSerializableArguments = null;
            } else {
                argumentsData = new byte[args.length][];
                notSerializableArguments = new Object[args.length];
                for (int i = 0; i < args.length; i++) {
                    if (args[i] instanceof Serializable) {
                        Serializable arg = (Serializable) args[i];
                        argumentsData[i] = SerializationSupport.serialize(arg);
                    } else {
                        argumentsData[i] = null;
                        notSerializableArguments[i] = args[i];
                    }
                }
            }

            UUID sessionId = AppContext.getSecurityContext() == null ? null : AppContext.getSecurityContext().getSessionId();
            LocalServiceInvocation invocation = new LocalServiceInvocation(
                    method.getName(), parameterTypeNames, argumentsData, notSerializableArguments, sessionId);

            LocalServiceInvocationResult result = invoker.invoke(invocation);
            AppContext.setSecurityContext(AppContext.getSecurityContext());//need reset application name in LogMDC for the current thread

            // don't use SerializationUtils.deserialize() here to avoid ClassNotFoundException
            if (result.getException() != null) {
                Throwable t = (Throwable) SerializationSupport.deserialize(result.getException());
                if (t instanceof RemoteException) {
                    Exception exception = ((RemoteException) t).getFirstCauseException();
                    if (exception != null) // This is a checked exception declared in a service method
                        throw exception;
                }
                throw t;
            } else {
                Object data;
                if (result.getNotSerializableData() == null) {
                    data = SerializationSupport.deserialize(result.getData());
                } else {
                    data = result.getNotSerializableData();
                }
                return data;
            }
        }
    }
}
