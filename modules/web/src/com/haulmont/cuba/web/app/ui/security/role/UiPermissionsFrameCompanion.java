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

package com.haulmont.cuba.web.app.ui.security.role;

import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.app.security.entity.UiPermissionTarget;
import com.haulmont.cuba.gui.app.security.entity.UiPermissionVariant;
import com.haulmont.cuba.gui.app.security.role.edit.tabs.UiPermissionsFrame;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;

public class UiPermissionsFrameCompanion implements UiPermissionsFrame.Companion {
    @Inject
    protected Messages messages;

    @Inject
    protected ComponentsFactory componentsFactory;

    @Override
    public void initPermissionsColoredColumns(Table<UiPermissionTarget> uiPermissionsTable) {
        uiPermissionsTable.addGeneratedColumn("permissionVariant", entity -> {
            UiPermissionVariant permissionVariant = entity.getPermissionVariant();
            if (permissionVariant == UiPermissionVariant.NOTSET)
                return null;

            Label label = componentsFactory.createComponent(Label.class);
            label.setHtmlEnabled(true);
            String labelValue = "<span style=\"role-permission-" + permissionVariant.getColor() + "\">" +
                    messages.getMessage(permissionVariant) + "</span>";
            label.setValue(labelValue);
            return label;
        });
    }
}