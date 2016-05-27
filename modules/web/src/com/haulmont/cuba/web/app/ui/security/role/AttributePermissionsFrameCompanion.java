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

import com.haulmont.cuba.gui.AppConfig;
import com.haulmont.cuba.gui.app.security.entity.AttributePermissionVariant;
import com.haulmont.cuba.gui.app.security.entity.AttributeTarget;
import com.haulmont.cuba.gui.app.security.entity.MultiplePermissionTarget;
import com.haulmont.cuba.gui.app.security.role.edit.tabs.AttributePermissionsFrame;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.haulmont.cuba.web.gui.components.WebComponentsUtils;

import java.util.Iterator;
import java.util.List;

public class AttributePermissionsFrameCompanion implements AttributePermissionsFrame.Companion {

    @Override
    public void initPermissionColoredColumn(final Table<MultiplePermissionTarget> propertyPermissionsTable) {
        propertyPermissionsTable.addGeneratedColumn("permissionsInfo", target -> {
            List<AttributeTarget> permissions = target.getPermissions();
            if (permissions.size() == 0)
                return null;

            Label label = AppConfig.getFactory().createComponent(Label.class);

            WebComponentsUtils.allowHtmlContent(label);

            int i = 0;
            StringBuilder builder = new StringBuilder();
            Iterator<AttributeTarget> iterator = permissions.iterator();
            while (iterator.hasNext() && i < MultiplePermissionTarget.SHOW_PERMISSIONS_COUNT) {
                AttributeTarget attributeTarget = iterator.next();
                AttributePermissionVariant permissionVariant = attributeTarget.getPermissionVariant();
                if (permissionVariant != AttributePermissionVariant.NOTSET) {
                    if (i < MultiplePermissionTarget.SHOW_PERMISSIONS_COUNT - 1) {
                        if (i > 0)
                            builder.append(", ");

                        builder.append("<span class=\"role-permission-").append(permissionVariant.getColor()).append("\">")
                                .append(attributeTarget.getId()).append("</span>");
                    } else {
                        builder.append(", ...");
                    }
                    i++;
                }
            }
            label.setValue(builder.toString());

            return label;
        });
    }

    @Override
    public void initTextFieldFilter(TextField entityFilter, Runnable runnable) {
        WebComponentsHelper.addEnterShortcut(entityFilter, runnable);
    }
}