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
package com.haulmont.chile.jpa.loader;

import com.haulmont.bali.util.ReflectionHelper;
import com.haulmont.chile.core.annotations.MetaClass;
import com.haulmont.chile.core.loader.ChileAnnotationsLoader;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.chile.core.model.Range;
import com.haulmont.chile.core.model.Session;
import com.haulmont.chile.core.model.impl.AbstractInstance;
import com.haulmont.chile.core.model.impl.MetaClassImpl;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;

import javax.persistence.*;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.List;

import static org.apache.commons.lang.StringUtils.isBlank;

public class JPAAnnotationsLoader extends ChileAnnotationsLoader {

    private Logger log = LoggerFactory.getLogger(JPAMetadataLoader.class);

    public JPAAnnotationsLoader(Session session) {
        super(session);
    }

    @Override
    protected List<Class<?>> getClasses(Resource[] resources) {
        List<Class<?>> result = super.getClasses(resources);

        for (Resource resource : resources) {
            if (resource.isReadable()) {
                MetadataReader metadataReader;
                try {
                    metadataReader = metadataReaderFactory.getMetadataReader(resource);
                } catch (IOException e) {
                    throw new RuntimeException("Unable to read metadata resource", e);
                }

                AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

                boolean isAnnotated = isEntityClass(annotationMetadata) || isEmbeddableClass(annotationMetadata);
                if (isAnnotated) {
                    ClassMetadata classMetadata = metadataReader.getClassMetadata();
                    Class c = ReflectionHelper.getClass(classMetadata.getClassName());
                    result.add(c);
                }
            }
        }

        return result;
    }

    protected boolean isEmbeddableClass(AnnotationMetadata annotationMetadata) {
        return annotationMetadata.isAnnotated(Embeddable.class.getName()) &&
                annotationMetadata.isAnnotated(MetaClass.class.getName());
    }

    protected boolean isEntityClass(AnnotationMetadata annotationMetadata) {
        return annotationMetadata.isAnnotated(MappedSuperclass.class.getName()) ||
                annotationMetadata.isAnnotated(Entity.class.getName());
    }

    @Override
    protected boolean isMetaPropertyField(Field field) {
        return field.isAnnotationPresent(Column.class)
                || field.isAnnotationPresent(ManyToOne.class)
                || field.isAnnotationPresent(OneToMany.class)
                || field.isAnnotationPresent(ManyToMany.class)
                || field.isAnnotationPresent(OneToOne.class)
                || field.isAnnotationPresent(Embedded.class)
                || field.isAnnotationPresent(EmbeddedId.class)
                || super.isMetaPropertyField(field);
    }

    @Override
    protected Class getFieldTypeAccordingAnnotations(Field field) {
        OneToOne oneToOneAnnotation = field.getAnnotation(OneToOne.class);
        OneToMany oneToManyAnnotation = field.getAnnotation(OneToMany.class);
        ManyToOne manyToOneAnnotation = field.getAnnotation(ManyToOne.class);
        ManyToMany manyToManyAnnotation = field.getAnnotation(ManyToMany.class);

        Class result = null;
        if (oneToOneAnnotation != null) {
            result = oneToOneAnnotation.targetEntity();
        } else if (oneToManyAnnotation != null) {
            result = oneToManyAnnotation.targetEntity();
        } else if (manyToOneAnnotation != null) {
            result = manyToOneAnnotation.targetEntity();
        } else if (manyToManyAnnotation != null) {
            result = manyToManyAnnotation.targetEntity();
        }
        return result;
    }

    @Override
    protected Class getTypeOverride(AnnotatedElement element) {
        Temporal temporal = element.getAnnotation(Temporal.class);
        if (temporal != null && temporal.value().equals(TemporalType.DATE))
            return java.sql.Date.class;
        else if (temporal != null && temporal.value().equals(TemporalType.TIME))
            return java.sql.Time.class;
        else
            return null;
    }

    @Override
    protected boolean isMandatory(Field field) {
        Column columnAnnotation = field.getAnnotation(Column.class);
        OneToOne oneToOneAnnotation = field.getAnnotation(OneToOne.class);
        OneToMany oneToManyAnnotation = field.getAnnotation(OneToMany.class);
        ManyToOne manyToOneAnnotation = field.getAnnotation(ManyToOne.class);
        ManyToMany manyToManyAnnotation = field.getAnnotation(ManyToMany.class);

        if (columnAnnotation != null) {
            return !columnAnnotation.nullable();
        } else if (oneToOneAnnotation != null) {
            return !oneToOneAnnotation.optional();
        } else if (oneToManyAnnotation != null) {
            return false;
        } else if (manyToOneAnnotation != null) {
            return !manyToOneAnnotation.optional();
        } else if (manyToManyAnnotation != null) {
            return false;
        } else {
            return super.isMandatory(field);
        }
    }

    @Override
    protected Range.Cardinality getCardinality(Field field) {
        if (field.isAnnotationPresent(Column.class)) {
            return Range.Cardinality.NONE;
        } else if (field.isAnnotationPresent(OneToOne.class)) {
            return Range.Cardinality.ONE_TO_ONE;
        } else if (field.isAnnotationPresent(OneToMany.class)) {
            return Range.Cardinality.ONE_TO_MANY;
        } else if (field.isAnnotationPresent(ManyToOne.class)) {
            return Range.Cardinality.MANY_TO_ONE;
        } else if (field.isAnnotationPresent(ManyToMany.class)) {
            return Range.Cardinality.MANY_TO_MANY;
        } else if (field.isAnnotationPresent(Embedded.class)) {
            return Range.Cardinality.ONE_TO_ONE;
        } else {
            return super.getCardinality(field);
        }
    }

    @Override
    protected String getInverseField(Field field) {
        OneToMany oneToManyAnnotation = field.getAnnotation(OneToMany.class);
        if (oneToManyAnnotation != null)
            return isBlank(oneToManyAnnotation.mappedBy()) ? null : oneToManyAnnotation.mappedBy();

        ManyToMany manyToManyAnnotation = field.getAnnotation(ManyToMany.class);
        if (manyToManyAnnotation != null)
            return isBlank(manyToManyAnnotation.mappedBy()) ? null : manyToManyAnnotation.mappedBy();

        OneToOne oneToOneAnnotation = field.getAnnotation(OneToOne.class);
        if (oneToOneAnnotation != null)
            return isBlank(oneToOneAnnotation.mappedBy()) ? null : oneToOneAnnotation.mappedBy();

        return null;
    }

    @Override
    protected MetaClassImpl createClass(Class<?> clazz, String packageName) {
        if (AbstractInstance.class.equals(clazz)
                || Object.class.equals(clazz)) {
            return null;
        }

        Entity entityAnnotation = clazz.getAnnotation(Entity.class);
        MappedSuperclass mappedSuperclassAnnotation = clazz.getAnnotation(MappedSuperclass.class);

        MetaClass metaClassAnnotation = clazz.getAnnotation(MetaClass.class);
        Embeddable embeddableAnnotation = clazz.getAnnotation(Embeddable.class);

        if ((entityAnnotation == null && mappedSuperclassAnnotation == null) &&
                (embeddableAnnotation == null) && (metaClassAnnotation == null)) {
            log.trace(String.format("Class '%s' isn't annotated as metadata entity, ignore it", clazz.getName()));
            return null;
        }

        String className = null;
        if (entityAnnotation != null) {
            className = entityAnnotation.name();
        } else if (metaClassAnnotation != null) {
            className = metaClassAnnotation.name();
        }

        if (StringUtils.isEmpty(className)) {
            className = clazz.getSimpleName();
        }

        return createClass(clazz, packageName, className);
    }

    @Override
    protected void onPropertyLoaded(MetaProperty metaProperty, Field field) {
        super.onPropertyLoaded(metaProperty, field);

        if (isPersistent(field)) {
            metaProperty.getAnnotations().put("persistent", true);

            if (isPrimaryKey(field)) {
                metaProperty.getAnnotations().put("primaryKey", true);
                metaProperty.getDomain().getAnnotations().put("primaryKey", metaProperty.getName());
            }

            if (isEmbedded(field)) {
                metaProperty.getAnnotations().put("embedded", true);
            }

            Column column = field.getAnnotation(Column.class);
            Lob lob = field.getAnnotation(Lob.class);
            if (column != null && column.length() != 0 && lob == null) {
                metaProperty.getAnnotations().put("length", column.length());
            }
        }

        Temporal temporal = field.getAnnotation(Temporal.class);
        if (temporal != null) {
            metaProperty.getAnnotations().put("temporal", temporal.value());
        }
    }

    protected boolean isPrimaryKey(Field field) {
        return field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class);
    }

    protected boolean isEmbedded(Field field) {
        return field.isAnnotationPresent(Embedded.class) || field.isAnnotationPresent(EmbeddedId.class);
    }

    protected boolean isPersistent(Field field) {
        return field.isAnnotationPresent(Column.class)
                || field.isAnnotationPresent(ManyToOne.class)
                || field.isAnnotationPresent(OneToMany.class)
                || field.isAnnotationPresent(ManyToMany.class)
                || field.isAnnotationPresent(OneToOne.class)
                || field.isAnnotationPresent(Embedded.class)
                || field.isAnnotationPresent(EmbeddedId.class);
    }
}