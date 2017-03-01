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
package com.haulmont.cuba.security.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.datatypes.impl.EnumClass;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.ReferenceToEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Metadata;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * Record containing information about entity lifecycle event.
 * Created by <code>EntityLog</code> bean.
 */
@Entity(name = "sec$EntityLog")
@Table(name = "SEC_ENTITY_LOG")
@Listeners("cuba_EntityLogItemDetachListener")
@SystemLevel
public class EntityLogItem extends BaseUuidEntity {

    private static final long serialVersionUID = 5859030306889056606L;

    public enum Type implements EnumClass<String> {
        CREATE("C"),
        MODIFY("M"),
        DELETE("D");

        private String id;

        Type(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }

        public static Type fromId(String value) {
            if ("C".equals(value))
                return CREATE;
            else if ("M".equals(value))
                return MODIFY;
            else if ("D".equals(value))
                return DELETE;
            else
                return null;
        }
    }

    @Column(name = "EVENT_TS")
    private Date eventTs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "CHANGE_TYPE", length = 1)
    private String type;

    @Column(name = "ENTITY", length = 100)
    private String entity;

    @Embedded
    private ReferenceToEntity entityRef;

    @Transient
    @MetaProperty
    private Set<EntityLogAttr> attributes;

    @Column(name = "CHANGES")
    private String changes;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Date getEventTs() {
        return eventTs;
    }

    public void setEventTs(Date eventTs) {
        this.eventTs = eventTs;
    }

    public Type getType() {
        return Type.fromId(type);
    }

    public void setType(Type type) {
        this.type = type.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<EntityLogAttr> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<EntityLogAttr> attributes) {
        this.attributes = attributes;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public ReferenceToEntity getEntityRef() {
        return entityRef;
    }

    public void setEntityRef(ReferenceToEntity entityRef) {
        this.entityRef = entityRef;
    }

    public void setObjectEntityId(Object entity) {
        if (entityRef == null) {
            entityRef = AppBeans.get(Metadata.class).create(ReferenceToEntity.class);
        }
        entityRef.setObjectEntityId(entity);
    }

    public Object getObjectEntityId() {
        return entityRef == null ? null : entityRef.getObjectEntityId();
    }
}