/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.desktop.gui.components;

import com.haulmont.cuba.gui.components.ProgressBar;
import com.haulmont.cuba.gui.data.ValueListener;
import com.haulmont.cuba.gui.components.compatibility.ComponentValueChangeListenerWrapper;
import org.apache.commons.lang.ObjectUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Desktop implementation of progress bar depending on swing JProgressBar component.
 *
 * @author Alexander Budarov
 * @version $Id$
 */
public class DesktopProgressBar extends DesktopAbstractComponent<JProgressBar> implements ProgressBar {

    protected boolean editable = true;
    protected List<ValueChangeListener> listeners = new ArrayList<>();
    protected Object prevValue;

    private static final int WHOLE_PROGRESS = 100;

    public DesktopProgressBar() {
        impl = new JProgressBar();
        impl.setMinimum(0);
        impl.setMaximum(WHOLE_PROGRESS);
    }

    @Override
    public void addListener(ValueListener listener) {
        addValueChangeListener(new ComponentValueChangeListenerWrapper(listener));
    }

    @Override
    public void removeListener(ValueListener listener) {
        removeValueChangeListener(new ComponentValueChangeListenerWrapper(listener));
    }

    protected void fireValueChanged(Object prevValue, Object value) {
        for (ValueChangeListener listener : new ArrayList<>(listeners)) {
            listener.valueChanged(new ValueChangeEvent(this, prevValue, value));
        }
    }

    @Override
    public void addValueChangeListener(ValueChangeListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeValueChangeListener(ValueChangeListener listener) {
        listeners.remove(listener);
    }

    @Override
    public boolean isIndeterminate() {
        return impl.isIndeterminate();
    }

    @Override
    public void setIndeterminate(boolean indeterminate) {
        impl.setIndeterminate(indeterminate);
    }

    @Override
    public <T> T getValue() {
        Float value = convertValueFromSwing(impl.getValue());
        return (T) value;
    }

    @Override
    public void setValue(Object value) {
        if (!ObjectUtils.equals(prevValue, value)) {
            updateComponent(value);
            fireChangeListeners(value);
        }
    }

    protected void fireChangeListeners(Object newValue) {
        Object oldValue = prevValue;
        prevValue = newValue;
        if (!ObjectUtils.equals(oldValue, newValue)) {
            fireValueChanged(oldValue, newValue);
        }
    }

    protected void updateComponent(Object value) {
        float floatValue = value != null ? ((Number) value).floatValue() : 0;
        int progress = convertValueToSwing(floatValue);
        impl.setValue(progress);
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    @Override
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    protected int convertValueToSwing(float progress) {
        return Math.round(progress * WHOLE_PROGRESS);
    }

    protected float convertValueFromSwing(int progress) {
        return (float) progress / (float) WHOLE_PROGRESS;
    }
}