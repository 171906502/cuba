/*
 * Copyright (c) 2008-2018 Haulmont.
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

package com.haulmont.cuba.gui.components.data.datagrid;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.data.TreeDataGridItems;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.HierarchicalDatasource;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class DatasourceTreeDataGridItems<E extends Entity<K>, K>
        extends SortableDatasourceDataGridItems<E, K>
        implements TreeDataGridItems<E> {

    protected List<Object> itemIdsOrder = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public DatasourceTreeDataGridItems(HierarchicalDatasource<E, K> datasource) {
        super((CollectionDatasource.Sortable<E, K>) datasource);
    }

    @SuppressWarnings("unchecked")
    protected HierarchicalDatasource<E, K> getHierarchicalDatasource() {
        return (HierarchicalDatasource<E, K>) datasource;
    }

    @Override
    public int getChildCount(E parent) {
        return Math.toIntExact(getChildren(parent).count());
    }

    @Override
    public Stream<E> getChildren(E item) {
        Collection<K> itemIds = item == null
                ? getHierarchicalDatasource().getRootItemIds()
                : getHierarchicalDatasource().getChildren(item.getId());

        return itemIds.stream()
                .map(id -> datasource.getItem(id));
    }

    @Override
    public boolean hasChildren(E item) {
        return getHierarchicalDatasource().hasChildren(item.getId());
    }

    @Nullable
    @Override
    public E getParent(E item) {
        Preconditions.checkNotNullArgument(item);
        K parentId = getHierarchicalDatasource().getParent(item.getId());
        return getHierarchicalDatasource().getItem(parentId);
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
    protected void datasourceCollectionChanged(CollectionDatasource.CollectionChangeEvent<E, K> e) {
        super.datasourceCollectionChanged(e);

        updateItemIdsOrder();
    }

    @Override
    public int indexOfItem(E item) {
        return itemIdsOrder.indexOf(item.getId());
    }

    protected void updateItemIdsOrder() {
        itemIdsOrder.clear();

        datasource.getItems()
                .stream()
                .filter(item -> getParent(item) == null)
                .forEach(this::addItemIdToOrder);
    }

    protected void addItemIdToOrder(E item) {
        itemIdsOrder.add(item.getId());
        getChildren(item).forEach(this::addItemIdToOrder);
    }
}