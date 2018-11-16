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
package com.haulmont.cuba.gui.data.impl;

import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.CollectionDatasourceListener;
import com.haulmont.cuba.core.entity.Entity;

import java.util.List;

/**
 * Adapter class for {@link CollectionDatasourceListener}. Use it if you need to implement only few methods.
 *
 * @deprecated Use {@link com.haulmont.cuba.gui.data.CollectionDatasource.CollectionChangeListener}
 *
 */
@Deprecated
public class CollectionDsListenerAdapter<T extends Entity> extends DsListenerAdapter<T> implements CollectionDatasourceListener<T> {

    @Override
    public void collectionChanged(CollectionDatasource ds, Operation operation, List<T> items) {
    }
}