/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.gui.exception;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.Frame;
import org.apache.commons.lang.StringUtils;
import org.eclipse.persistence.exceptions.EclipseLinkException;

import javax.annotation.ManagedBean;
import javax.annotation.Nullable;

/**
 * Handles database "numeric overflow" exception.
 *
 * @author degtyarjov
 * @version $Id$
 */
@ManagedBean("cuba_NumericOverflowExceptionHandler")
public class NumericOverflowExceptionHandler extends AbstractGenericExceptionHandler {

    public NumericOverflowExceptionHandler() {
        // todo EL
        super(EclipseLinkException.class.getName());
    }

    @Override
    protected boolean canHandle(String className, String message, @Nullable Throwable throwable) {
        return StringUtils.containsIgnoreCase(message, "Numeric field overflow");
    }

    @Override
    protected void doHandle(String className, String message, @Nullable Throwable throwable, WindowManager windowManager) {
        Messages messages = AppBeans.get(Messages.NAME);
        String msg = messages.getMessage(getClass(), "numericFieldOverflow.message");
        windowManager.showNotification(msg, Frame.NotificationType.ERROR);
    }
}