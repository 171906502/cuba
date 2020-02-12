/*
 * Copyright (c) 2008-2018 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haulmont.cuba.gui.components.data.datagrid;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.data.TreeDataGridItems;
import com.haulmont.cuba.gui.model.CollectionContainer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ContainerTreeDataGridItems<E extends Entity>
            extends ContainerDataGridItems<E>
            implements TreeDataGridItems<E> {

    protected List<Object> itemIdsOrder = new ArrayList<>();

    private final String hierarchyProperty;

    public ContainerTreeDataGridItems(CollectionContainer<E> container, String hierarchyProperty) {
        super(container);
        this.hierarchyProperty = hierarchyProperty;
    }

    @Override
    public int getChildCount(E parent) {
        return Math.toIntExact(getChildren(parent).count());
    }

    @Override
    public Stream<E> getChildren(E item) {
        if (item == null) {
            // root items
            return container.getItems().stream()
                    .filter(it -> {
                        E parentItem = it.getValue(hierarchyProperty);
                        return parentItem == null || (container.getItemOrNull(parentItem.getId()) == null);
                    });
        } else {
            return container.getItems().stream()
                    .filter(it -> {
                        E parentItem = it.getValue(hierarchyProperty);
                        return parentItem != null && parentItem.equals(item);
                    });
        }
    }

    @Override
    public boolean hasChildren(E item) {
        return container.getItems().stream().anyMatch(it -> {
            E parentItem = it.getValue(hierarchyProperty);
            return parentItem != null && parentItem.equals(item);
        });
    }

    @Nullable
    @Override
    public E getParent(E item) {
        Preconditions.checkNotNullArgument(item);
        return item.getValue(hierarchyProperty);
    }

    @Override
    public void sort(Object[] propertyId, boolean[] ascending) {
        super.sort(propertyId, ascending);

        updateItemIdsOrder();
    }

    @Override
    public void resetSortOrder() {
        super.resetSortOrder();

        updateItemIdsOrder();
    }

    @Override
    protected void containerCollectionChanged(CollectionContainer.CollectionChangeEvent<E> e) {
        super.containerCollectionChanged(e);

        updateItemIdsOrder();
    }

    @Override
    public int indexOfItem(E item) {
        return itemIdsOrder.indexOf(item.getId());
    }

    protected void updateItemIdsOrder() {
        itemIdsOrder.clear();

        container.getItems()
                .stream()
                .filter(item -> getParent(item) == null)
                .forEach(this::addItemIdToOrder);
    }

    protected void addItemIdToOrder(E item) {
        itemIdsOrder.add(item.getId());
        getChildren(item).forEach(this::addItemIdToOrder);
    }
}
