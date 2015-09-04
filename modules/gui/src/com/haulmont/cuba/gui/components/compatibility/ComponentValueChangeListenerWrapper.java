/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.gui.components.compatibility;

import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.data.ValueListener;

/**
 * @author artamonov
 * @version $Id$
 */
@Deprecated
public class ComponentValueChangeListenerWrapper implements Component.ValueChangeListener {

    protected final ValueListener listener;

    public ComponentValueChangeListenerWrapper(ValueListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        ComponentValueChangeListenerWrapper that = (ComponentValueChangeListenerWrapper) obj;

        return this.listener.equals(that.listener);
    }

    @Override
    public int hashCode() {
        return listener.hashCode();
    }

    @Override
    public void valueChanged(Component.ValueChangeEvent e) {
        listener.valueChanged(e.getComponent(), "value", e.getPrevValue(), e.getValue());
    }
}