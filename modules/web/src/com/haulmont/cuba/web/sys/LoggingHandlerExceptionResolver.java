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
 */

package com.haulmont.cuba.web.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Logs all exceptions that occur in MVC controllers
 */
public class LoggingHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {

    protected int EXCEPTION_RESOLVER_ORDER = 1000;

    private static final Logger log = LoggerFactory.getLogger(LoggingHandlerExceptionResolver.class);

    protected List<Class<? extends Exception>> excludedExceptions = new ArrayList<>();

    /**
     * Sets the list of exception classes that must not be logged
     */
    public void setExcludedExceptions(List<Class<? extends Exception>> excludedExceptions) {
        this.excludedExceptions = excludedExceptions;
    }

    @Override
    public int getOrder() {
        return EXCEPTION_RESOLVER_ORDER;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (!excludedExceptions.contains(ex.getClass())) {
            log.error("Exception in MVC controller", ex);
        }
        return null;
    }
}