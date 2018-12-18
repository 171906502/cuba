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

package com.haulmont.cuba.gui.builders;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.client.ClientConfig;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.ExtendedEntities;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.WindowParams;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.components.SupportsUserAction;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.components.data.DataUnit;
import com.haulmont.cuba.gui.components.data.meta.ContainerDataUnit;
import com.haulmont.cuba.gui.config.WindowConfig;
import com.haulmont.cuba.gui.config.WindowInfo;
import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.screen.compatibility.LegacyFrame;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.function.Consumer;

import static com.haulmont.cuba.gui.screen.UiControllerUtils.getScreenContext;

@Component("cuba_EditorBuilderProcessor")
public class EditorBuilderProcessor {

    @Inject
    protected Metadata metadata;
    @Inject
    protected ExtendedEntities extendedEntities;
    @Inject
    protected WindowConfig windowConfig;
    @Inject
    protected ClientConfig clientConfig;

    @SuppressWarnings("unchecked")
    public  <E extends Entity, S extends Screen> S buildEditor(EditorBuilder<E> builder) {
        if (builder.getMode() == EditMode.EDIT && builder.getEditedEntity() == null) {
            throw new IllegalStateException(String.format("Editor of %s cannot be open with mode EDIT, entity is not set",
                    builder.getEntityClass()));
        }

        FrameOwner origin = builder.getOrigin();
        Screens screens = getScreenContext(origin).getScreens();

        ListComponent<E> listComponent = builder.getListComponent();

        CollectionContainer<E> container = null;

        if (listComponent != null) {
            DataUnit items = listComponent.getItems();
            CollectionContainer<E> listComponentContainer = items instanceof ContainerDataUnit ?
                    ((ContainerDataUnit) items).getContainer() : null;
            container = builder.getContainer() != null ? builder.getContainer() : listComponentContainer;
        }

        E entity = initEntity(builder, container);

        Screen screen = createScreen(builder, screens, entity);

        EditorScreen<E> editorScreen = (EditorScreen<E>) screen;
        editorScreen.setEntityToEdit(entity);

        DataContext parentDataContext = builder.getParentDataContext();
        if (parentDataContext != null) {
            UiControllerUtils.getScreenData(screen).getDataContext().setParent(parentDataContext);
        } else if (container instanceof Nested) {
            setupParentDataContextForComposition(origin, screen, (Nested) container);
        }

        if (container != null) {
            CollectionContainer<E> ct = container;
            screen.addAfterCloseListener(event -> {
                CloseAction closeAction = event.getCloseAction();
                if (isCommitCloseAction(closeAction)) {
                    if (builder.getMode() == EditMode.CREATE) {
                        boolean addsFirst;

                        if (!(ct instanceof Nested)) {
                            addsFirst = clientConfig.getCreateActionAddsFirst();
                            if (builder.getAddFirst() != null) {
                                addsFirst = builder.getAddFirst();
                            }
                        } else {
                            addsFirst = false;
                        }

                        if (ct instanceof Nested || !addsFirst) {
                            ct.getMutableItems().add(editorScreen.getEditedEntity());
                        } else {
                            ct.getMutableItems().add(0, editorScreen.getEditedEntity());
                        }
                    } else {
                        ct.replaceItem(editorScreen.getEditedEntity());
                    }
                }
                if (listComponent instanceof com.haulmont.cuba.gui.components.Component.Focusable) {
                    ((com.haulmont.cuba.gui.components.Component.Focusable) listComponent).focus();
                }
            });
        }

        HasValue<E> field = builder.getField();
        if (field != null) {
            screen.addAfterCloseListener(event -> {
                CloseAction closeAction = event.getCloseAction();
                if (isCommitCloseAction(closeAction)) {
                    E editedEntity = editorScreen.getEditedEntity();

                    if (field instanceof SupportsUserAction) {
                        ((SupportsUserAction) field).setValueFromUser(editedEntity);
                    } else {
                        field.setValue(editedEntity);
                    }
                }

                if (field instanceof com.haulmont.cuba.gui.components.Component.Focusable) {
                    ((com.haulmont.cuba.gui.components.Component.Focusable) field).focus();
                }
            });
        }

        if (builder instanceof EditorClassBuilder) {
            @SuppressWarnings("unchecked")
            Consumer<AfterScreenCloseEvent> closeListener = ((EditorClassBuilder) builder).getCloseListener();
            if (closeListener != null) {
                screen.addAfterCloseListener(new AfterCloseListenerAdapter(closeListener));
            }
        }

        return (S) screen;
    }

    protected <E extends Entity> E initEntity(EditorBuilder<E> builder, CollectionContainer<E> container) {
        E entity;

        if (builder.getMode() == EditMode.CREATE) {
            if (builder.getNewEntity() == null) {
                entity = metadata.create(builder.getEntityClass());
            } else {
                entity = builder.getNewEntity();
            }
            if (container instanceof Nested) {
                initializeNestedEntity(entity, (Nested) container);
            }
            if (builder.getInitializer() != null) {
                builder.getInitializer().accept(entity);
            }
        } else {
            entity = builder.getEditedEntity();
        }

        return entity;
    }

    protected <E extends Entity> Screen createScreen(EditorBuilder<E> builder, Screens screens, E entity) {
        Screen screen;

        if (builder instanceof EditorClassBuilder) {
            @SuppressWarnings("unchecked")
            Class<? extends Screen> screenClass = ((EditorClassBuilder) builder).getScreenClass();

            if (screenClass == null) {
                throw new IllegalArgumentException("Screen class is not set");
            }

            screen = screens.create(screenClass, builder.getLaunchMode(), builder.getOptions());
        } else {
            String editorScreenId;

            if (builder.getScreenId() != null) {
                editorScreenId = builder.getScreenId();
            } else {
                editorScreenId = windowConfig.getEditorScreen(entity).getId();
            }

            if (editorScreenId == null) {
                throw new IllegalArgumentException("Screen id is not set");
            }

            // legacy screens support
            WindowInfo windowInfo = windowConfig.getWindowInfo(editorScreenId);
            ScreenOptions options = builder.getOptions();

            if (LegacyFrame.class.isAssignableFrom(windowInfo.getControllerClass())
                    && options == FrameOwner.NO_OPTIONS) {
                HashMap<String, Object> paramsMap = new HashMap<>();
                paramsMap.put(WindowParams.ITEM.name(), entity);
                options = new MapScreenOptions(paramsMap);
            }

            screen = screens.create(editorScreenId, builder.getLaunchMode(), options);
        }

        if (!(screen instanceof EditorScreen)) {
            throw new IllegalArgumentException(String.format("Screen %s does not implement EditorScreen: %s",
                    screen.getId(), screen.getClass()));
        }

        return screen;
    }

    protected <E extends Entity> void initializeNestedEntity(E entity, Nested container) {
        InstanceContainer masterContainer = container.getMaster();
        String property = container.getProperty();

        MetaClass masterMetaClass = masterContainer.getEntityMetaClass();
        MetaProperty metaProperty = masterMetaClass.getPropertyNN(property);

        MetaProperty inverseProp = metaProperty.getInverse();
        if (inverseProp != null) {
            Class<?> inversePropClass = extendedEntities.getEffectiveClass(inverseProp.getDomain());
            Class<?> containerEntityClass = extendedEntities.getEffectiveClass(((CollectionContainer) container).getEntityMetaClass());
            if (inversePropClass.isAssignableFrom(containerEntityClass)) {
                entity.setValue(inverseProp.getName(), masterContainer.getItem());
            }
        }
    }

    protected void setupParentDataContextForComposition(FrameOwner origin, Screen screen, Nested container) {
        InstanceContainer masterContainer = container.getMaster();
        String property = container.getProperty();

        MetaClass masterMetaClass = masterContainer.getEntityMetaClass();
        MetaProperty metaProperty = masterMetaClass.getPropertyNN(property);

        if (metaProperty.getType() == MetaProperty.Type.COMPOSITION) {
            ScreenData screenData = UiControllerUtils.getScreenData(origin);
            UiControllerUtils.getScreenData(screen).getDataContext().setParent(screenData.getDataContext());
        }
    }

    protected boolean isCommitCloseAction(CloseAction closeAction) {
        return (closeAction instanceof StandardCloseAction)
                && ((StandardCloseAction) closeAction).getActionId().equals(Window.COMMIT_ACTION_ID);
    }
}