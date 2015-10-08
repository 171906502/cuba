/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.core.app;

import com.haulmont.bali.util.Preconditions;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.core.PersistenceSecurity;
import com.haulmont.cuba.core.entity.BaseGenericIdEntity;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.core.sys.persistence.CubaEntityFetchGroup;
import org.eclipse.persistence.queries.FetchGroup;
import org.eclipse.persistence.queries.FetchGroupTracker;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Supports enforcing entity attribute permissions on Middleware.
 *
 * @author Konstantin Krivopustov
 * @version $Id$
 */
@Component(AttributeSecuritySupport.NAME)
public class AttributeSecuritySupport {

    public static final String NAME = "cuba_AttributeSecuritySupport";

    @Inject
    protected Metadata metadata;

    @Inject
    protected MetadataTools metadataTools;

    @Inject
    protected PersistenceSecurity security;

    @Inject
    protected ServerConfig config;

    /**
     * Removes restricted attributes from a view.
     *
     * @param view  source view
     * @return      restricted view
     */
    public View createRestrictedView(View view) {
        if (!config.getEntityAttributePermissionChecking()) {
            return view;
        }
        Preconditions.checkNotNullArgument(view, "view is null");

        View restrictedView = new View(view.getEntityClass());
        copyViewConsideringPermissions(view, restrictedView);
        return restrictedView;
    }

    private void copyViewConsideringPermissions(View srcView, View dstView) {
        MetaClass metaClass = metadata.getClassNN(srcView.getEntityClass());
        for (ViewProperty property : srcView.getProperties()) {
            if (security.isEntityAttrReadPermitted(metaClass, property.getName())) {
                View viewCopy = null;
                if (property.getView() != null) {
                    viewCopy = new View(property.getView().getEntityClass(), property.getView().getName() + "(restricted)");
                    copyViewConsideringPermissions(property.getView(), viewCopy);
                }
                dstView.addProperty(property.getName(), viewCopy, property.getFetchMode());
            }
        }
    }

    /**
     * Should be called after loading an entity from the database.
     *
     * @param entity just loaded detached entity
     */
    public void afterLoad(Entity entity) {
        if (!config.getEntityAttributePermissionChecking()) {
            return;
        }
        if (entity != null) {
            metadataTools.traverseAttributes(entity, new FillingInaccessibleAttributesVisitor());
        }
    }

    /**
     * Should be called after loading a list of entities from the database.
     *
     * @param entities list of just loaded detached entities
     */
    public void afterLoad(Collection<? extends Entity> entities) {
        if (!config.getEntityAttributePermissionChecking()) {
            return;
        }
        Preconditions.checkNotNullArgument(entities, "entities list is null");

        for (Entity entity : entities) {
            afterLoad(entity);
        }
    }

    /**
     * Should be called before persisting a new entity.
     *
     * @param entity new entity
     */
    public void beforePersist(Entity entity) {
        if (!config.getEntityAttributePermissionChecking()) {
            return;
        }
        metadata.getTools().traverseAttributes(entity, new ClearReadOnlyAttributesVisitor());
    }

    /**
     * Should be called before merging an entity.
     *
     * @param entity detached entity
     */
    public void beforeMerge(Entity entity) {
        if (!config.getEntityAttributePermissionChecking()) {
            return;
        }
        MetaClass metaClass = metadata.getClassNN(entity.getClass());
        FetchGroup fetchGroup = ((FetchGroupTracker) entity)._persistence_getFetchGroup();
        if (fetchGroup != null) {
            List<String> attributesToRemove = new ArrayList<>();
            for (String attrName : fetchGroup.getAttributeNames()) {
                String[] parts = attrName.split("\\.");
                MetaClass tmpMetaClass = metaClass;
                for (String part : parts) {
                    if (!security.isEntityAttrUpdatePermitted(tmpMetaClass, part)) {
                        attributesToRemove.add(attrName);
                        break;
                    }
                    MetaProperty metaProperty = tmpMetaClass.getPropertyNN(part);
                    if (metaProperty.getRange().isClass()) {
                        tmpMetaClass = metaProperty.getRange().asClass();
                    }
                }
            }
            if (!attributesToRemove.isEmpty()) {
                List<String> attributeNames = new ArrayList<>(fetchGroup.getAttributeNames());
                attributeNames.removeAll(attributesToRemove);
                ((FetchGroupTracker) entity)._persistence_setFetchGroup(new CubaEntityFetchGroup(attributeNames));
            }
        } else {
            List<String> attributeNames = new ArrayList<>();
            for (MetaProperty metaProperty : metaClass.getProperties()) {
                if (security.isEntityAttrUpdatePermitted(metaClass, metaProperty.getName())) {
                    attributeNames.add(metaProperty.getName());
                }
            }
            ((FetchGroupTracker) entity)._persistence_setFetchGroup(new CubaEntityFetchGroup(attributeNames));
        }
    }

    /**
     * Should be called after merging an entity and transaction commit.
     *
     * @param entity detached entity
     */
    public void afterMerge(Entity entity, View view) {
        if (!config.getEntityAttributePermissionChecking()) {
            return;
        }
        if (entity != null) {
            metadataTools.traverseAttributesByView(view, entity, new ClearInaccessibleAttributesVisitor());
        }
    }

    private void addInaccessibleAttribute(BaseGenericIdEntity entity, String property) {
        String[] attributes = entity.__inaccessibleAttributes();
        attributes = attributes == null ? new String[1] : Arrays.copyOf(attributes, attributes.length + 1);
        attributes[attributes.length - 1] = property;
        entity.__inaccessibleAttributes(attributes);
    }

    private class FillingInaccessibleAttributesVisitor implements EntityAttributeVisitor {
        @Override
        public void visit(Entity entity, MetaProperty property) {
            MetaClass metaClass = metadata.getClassNN(entity.getClass());
            if (!security.isEntityAttrReadPermitted(metaClass, property.getName())) {
                addInaccessibleAttribute((BaseGenericIdEntity) entity, property.getName());
            }
        }
    }

    private class ClearReadOnlyAttributesVisitor implements EntityAttributeVisitor {
        @Override
        public void visit(Entity entity, MetaProperty property) {
            MetaClass metaClass = metadata.getClassNN(entity.getClass());
            if (!metadataTools.isSystem(property)
                    && !property.isReadOnly()
                    && !security.isEntityAttrUpdatePermitted(metaClass, property.getName())
                    && PersistenceHelper.isLoaded(entity, property.getName())) {
                entity.setValue(property.getName(), null);
            }
        }
    }

    private class ClearInaccessibleAttributesVisitor implements EntityAttributeVisitor {
        @Override
        public void visit(Entity entity, MetaProperty property) {
            MetaClass metaClass = metadata.getClassNN(entity.getClass());
            if (!security.isEntityAttrReadPermitted(metaClass, property.getName())) {
                addInaccessibleAttribute((BaseGenericIdEntity) entity, property.getName());
                if (!metadataTools.isSystem(property)
                        && !property.isReadOnly()
                        && PersistenceHelper.isLoaded(entity, property.getName())) {
                    entity.setValue(property.getName(), null);
                }
            }
        }
    }
}
