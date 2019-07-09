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

package com.haulmont.cuba.web.app.ui.jmxcontrol.inspect.operation;

import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.ScrollBoxLayout;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.web.jmx.JmxControlException;
import com.haulmont.cuba.web.jmx.entity.AttributeHelper;
import com.vaadin.shared.ui.ContentMode;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.inject.Inject;
import javax.management.MBeanException;
import java.lang.reflect.UndeclaredThrowableException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Map;

public class OperationResultWindow extends AbstractWindow {
    @Inject
    protected Label<String> resultLabel;

    @Inject
    protected ScrollBoxLayout resultContainer;

    @Inject
    protected ExportDisplay exportDisplay;

    @Inject
    protected TimeSource timeSource;

    @WindowParam
    protected Object result;

    @WindowParam
    protected Throwable exception;

    @WindowParam
    protected String methodName;

    @WindowParam
    protected String beanName;

    @Inject
    protected UiComponents uiComponents;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        if (exception != null) {
            Label<String> traceLabel = uiComponents.create(Label.NAME);
            traceLabel.setValue(getExceptionMessage(exception));

            traceLabel.withUnwrapped(com.vaadin.ui.Label.class, vLabel ->
                    vLabel.setContentMode(ContentMode.PREFORMATTED));

            resultLabel.setValue(getMessage("operationResult.exception"));
            resultContainer.add(traceLabel);
        } else if (result != null) {
            Label<String> valueHolder = uiComponents.create(Label.NAME);
            valueHolder.setValue(AttributeHelper.convertToString(result));

            valueHolder.withUnwrapped(com.vaadin.ui.Label.class, vLabel ->
                    vLabel.setContentMode(ContentMode.PREFORMATTED));

            resultLabel.setValue(getMessage("operationResult.result"));
            resultContainer.add(valueHolder);
        } else {
            resultLabel.setValue(getMessage("operationResult.void"));
        }
    }

    protected String getExceptionMessage(Throwable exception) {
        if (exception instanceof UndeclaredThrowableException)
            exception = exception.getCause();

        if (exception instanceof JmxControlException) {
            exception = exception.getCause();

            if (exception instanceof MBeanException) {
                exception = exception.getCause();
            }
        }

        String msg;
        if (exception != null) {
            msg = String.format("%s: \n%s\n%s",
                    exception.getClass().getName(),
                    exception.getMessage(),
                    ExceptionUtils.getStackTrace(exception));
        } else {
            msg = "";
        }
        return msg;
    }

    public void close() {
        close(CLOSE_ACTION_ID);
    }

    public void exportToFile() {
        if (result != null || exception != null) {
            String exportResult = String.format("JMX Method %s : %s result\n", beanName, methodName);

            if (result != null) {
                exportResult += AttributeHelper.convertToString(result);
            }
            if (exception != null) {
                exportResult += getExceptionMessage(exception);
            }

            byte[] bytes = exportResult.getBytes(StandardCharsets.UTF_8);
            exportDisplay.show(new ByteArrayDataProvider(bytes),
                    String.format("jmx.%s-%s-%s.log",
                            beanName,
                            methodName,
                            new SimpleDateFormat("HH:mm:ss").format(
                                    timeSource.currentTimestamp())));
        } else {
            showNotification(getMessage("operationResult.resultIsEmpty"), NotificationType.HUMANIZED);
        }
    }
}