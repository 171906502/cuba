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
package com.haulmont.cuba.gui.components;

import com.haulmont.cuba.gui.app.security.role.edit.UiPermissionDescriptor;
import com.haulmont.cuba.gui.data.ValueListener;
import com.haulmont.cuba.gui.presentations.Presentations;
import org.dom4j.Element;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Root of the GenericUI components hierarchy
 *
 */
public interface Component {

    enum Alignment {
        TOP_RIGHT,
        TOP_LEFT,
        TOP_CENTER,
        MIDDLE_RIGHT,
        MIDDLE_LEFT,
        MIDDLE_CENTER,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER
    }

    int UNITS_PIXELS = 0;
    int UNITS_PERCENTAGE = 8;

    String AUTO_SIZE = "-1px";
    int AUTO_SIZE_PX = -1;

    /** Component ID as defined in <code>id</code> attribute */
    String getId();
    /** Set component ID */
    void setId(String id);

    /**
     * @return Parent of component.
     */
    Component getParent();

    /**
     * INTERNAL.<br/>
     *
     * {@link Component.Container#add(Component)} is normally used for adding components
     * to a parent and the used method will call this method implicitly.
     *
     * @param parent Parent component
     */
    void setParent(Component parent);

    String getDebugId();
    /** INTERNAL. Managed by debug Id system. */
    void setDebugId(String id);

    /**
     * Are the component and its parent enabled?
     */
    boolean isEnabled();
    /** Set component enabled state */
    void setEnabled(boolean enabled);

    /**
     * Is the component responsive?
     */
    boolean isResponsive();
    /**
     * Set component to be responsive by width and height.
     *
     * If responsive flag is true then you can use conditional CSS rules that respond to size changes in the browser.
     * You can set specific rules using "width-range" or "height-range" properties in CSS files.
     */
    void setResponsive(boolean responsive);

    /**
     * Are the component and its parent visible?
     */
    boolean isVisible();
    /** Set component visibility */
    void setVisible(boolean visible);

    /**
     * Is the component visible regardless of the parent?
     */
    boolean isVisibleItself();

    /**
     * Is the component enabled regardless of the parent?
     */
    boolean isEnabledItself();

    /** Set focus to this component */
    void requestFocus();

    /** Get component height in {@link #getHeightUnits()} */
    float getHeight();

    /** Height units: {@link #UNITS_PIXELS}, {@link #UNITS_PERCENTAGE} */
    int getHeightUnits();

    /** Set component height in {@link #getHeightUnits()} */
    void setHeight(String height);

    /** Get component width in {@link #getWidthUnits()} */
    float getWidth();

    /** Width units: {@link #UNITS_PIXELS}, {@link #UNITS_PERCENTAGE} */
    int getWidthUnits();

    /** Set component width in {@link #getWidthUnits()} */
    void setWidth(String width);

    Alignment getAlignment();
    void setAlignment(Alignment alignment);

    /**
     * Styles implementation is client-type-specific.
     *
     * @return current style name.
     */
    String getStyleName();

    /**
     * Sets one or more style names of the component, replacing any
     * previous styles. Multiple styles can be specified as a
     * space-separated list of style names.
     *
     * Styles implementation is client-type-specific.
     *
     * @param styleName one or more style names separated by space.
     * */
    void setStyleName(String styleName);

    /**
     * Adds one or more style names to this component. Multiple styles can be
     * specified as a space-separated list of style names.
     *
     * @param styleName one or more style names separated by space.
     */
    void addStyleName(String styleName);

    /**
     * Removes one or more style names from component. Multiple styles can be
     * specified as a space-separated list of style names.
     *
     * @param styleName one or more style names separated by space.
     */
    void removeStyleName(String styleName);

    /**
     * Get client specific component instance. Can be used in client module to simplify invocation of underlying API.
     * <br/>
     * Example:
     * <pre>
     * com.vaadin.ui.TextField vTextField = textField.unwrap(com.vaadin.ui.TextField.class);
     * </pre>
     *
     * @param internalComponentClass class of underlying component implementation based on Vaadin or Swing
     * @param <X> type of internal class
     * @return internal client specific component
     */
    <X> X unwrap(Class<X> internalComponentClass);

    /**
     * Get the outmost external container of client specific component instance. Can be used in client module to simplify invocation of underlying API.
     * <br/>
     * Example:
     * <pre>
     * com.vaadin.ui.Layout vLayout = table.unwrapComposition(com.vaadin.ui.Layout.class);
     * </pre>
     *
     * @param internalCompositionClass class of underlying composition implementation based on Vaadin or Swing
     * @param <X> type of internal class
     * @return internal client specific component
     */
    <X> X unwrapComposition(Class<X> internalCompositionClass);

    /**
     * Component which can contain other components
     */
    interface Container extends Component {
        void add(Component childComponent);
        void remove(Component childComponent);

        void removeAll();

        /**
         * Get component directly owned by this container.
         * @return component or null if not found
         */
        @Nullable
        Component getOwnComponent(String id);

        /**
         * Get component belonging to the whole components tree below this container.
         * @return component or null if not found
         */
        @Nullable
        Component getComponent(String id);

        /**
         * Get component belonging to the whole components tree below this container.
         *
         * @return component. Throws exception if not found.
         */
        @Nonnull
        Component getComponentNN(String id);

        /** Get all components directly owned by this container */
        Collection<Component> getOwnComponents();

        /** Get all components belonging to the whole components tree below this container */
        Collection<Component> getComponents();
    }

    interface OrderedContainer extends Container {
        void add(Component childComponent, int index);
        int indexOf(Component component);
    }

    interface HasNamedComponents {
        /**
         * Get subcomponent by name.
         * @return component or null if not found
         */
        @Nullable
        Component getComponent(String id);
    }

    /**
     * Component delegating work to some "wrapped" client-specific implementation
     */
    interface Wrapper extends Component {
        Object getComponent();
        Object getComposition();
    }

    /**
     * Component belonging to a frame
     */
    interface BelongToFrame extends Component {
        Frame getFrame();
        void setFrame(Frame frame);
    }

    /**
     * Object having a caption
     */
    interface HasCaption {
        String getCaption();
        void setCaption(String caption);

        String getDescription();
        void setDescription(String description);
    }

    /**
     * Object having a border
     */
    interface HasBorder {
        boolean isBorderVisible();
        void setBorderVisible(boolean borderVisible);
    }

    /**
     * Describes value change event.
     */
    class ValueChangeEvent {
        private final Component.HasValue component;
        private final Object prevValue;
        private final Object value;

        public ValueChangeEvent(Component.HasValue component, Object prevValue, Object value) {
            this.component = component;
            this.prevValue = prevValue;
            this.value = value;
        }

        /**
         * @return component
         */
        public Component.HasValue getComponent() {
            return component;
        }

        /**
         * @return previous value
         */
        @Nullable
        public Object getPrevValue() {
            return prevValue;
        }

        /**
         * @return current value
         */
        @Nullable
        public Object getValue() {
            return value;
        }
    }

    /**
     * Listener to value change events.
     */
    interface ValueChangeListener {
        /**
         * Called when value of Component changed.
         *
         * @param e event object
         */
        void valueChanged(ValueChangeEvent e);
    }

    /**
     * Object having a value.
     */
    interface HasValue extends Editable, BelongToFrame {
        <T> T getValue();

        void setValue(Object value);

        /**
         * @deprecated Use {@link #addValueChangeListener(ValueChangeListener)}
         */
        @Deprecated
        void addListener(ValueListener listener);
        @Deprecated
        void removeListener(ValueListener listener);

        void addValueChangeListener(ValueChangeListener listener);
        void removeValueChangeListener(ValueChangeListener listener);
    }

    /**
     * Object having a formatter
     */
    interface HasFormatter {
        Formatter getFormatter();
        void setFormatter(Formatter formatter);
    }

    /**
     * Object having an XML descriptor attached
     */
    interface HasXmlDescriptor {
        Element getXmlDescriptor();
        void setXmlDescriptor(Element element);
    }

    /**
     * A component containing {@link Action}s
     */
    interface ActionsHolder extends Component {
        /**
         * Add an action to the component
         */
        void addAction(Action action);

        /**
         * Add an action to the component with index.
         */
        void addAction(Action action, int index);

        /**
         * Remove the action from the component
         */
        void removeAction(@Nullable Action action);

        /**
         * Remove the action by its ID. If there is no action with that ID, nothing happens.
         */
        void removeAction(@Nullable String id);

        /**
         * Remove all actions from the component
         */
        void removeAllActions();

        /**
         * @return unmodifiable collection of actions
         */
        Collection<Action> getActions();

        /**
         * @return an action by its ID, or null if not found
         */
        @Nullable
        Action getAction(String id);

        /**
         * @return an action by its ID
         * @throws java.lang.IllegalArgumentException if not found
         */
        @Nonnull
        Action getActionNN(String id);
    }

    interface SecuredActionsHolder extends ActionsHolder {

        ActionsPermissions getActionsPermissions();
    }

    /**
     * Component supporting "editable" state.
     * Editable means not read-only, so user can view a value but can not edit it. Not editable value can be copied to
     * clipboard.
     */
    interface Editable extends Component {
        boolean isEditable();
        void setEditable(boolean editable);
    }

    /**
     * Component supporting "focusable" state.
     * Focusable means that component can be focused by TAB button.
     */
    interface Focusable extends Component {
        /**
         * Is component focusable?
         */
        boolean isFocusable();
        /**
         * Set component focusability
         */
        void setFocusable(boolean focusable);
    }

    /**
     * Object supporting save/restore of user settings.
     * @see com.haulmont.cuba.security.app.UserSettingService
     */
    interface HasSettings {
        void applySettings(Element element);
        boolean saveSettings(Element element);

        boolean isSettingsEnabled();
        void setSettingsEnabled(boolean settingsEnabled);
    }

    /**
     * Describes expanded state change event of {@link com.haulmont.cuba.gui.components.Component.Collapsable}.
     */
    class ExpandedStateChangeEvent {
        private final Component.Collapsable component;
        private final boolean expanded;

        public ExpandedStateChangeEvent(Collapsable component, boolean expanded) {
            this.component = component;
            this.expanded = expanded;
        }

        public Collapsable getComponent() {
            return component;
        }

        /**
         * @return true if Component has been expanded.
         */
        public boolean isExpanded() {
            return expanded;
        }
    }

    /**
     * Listener to expanded state change events.
     */
    interface ExpandedStateChangeListener {
        /**
         * Called when expanded state of {@link com.haulmont.cuba.gui.components.Component.Collapsable} changed.
         *
         * @param e event object
         */
        void expandedStateChanged(ExpandedStateChangeEvent e);
    }

    /**
     * Is able to collapse (folding)
     */
    interface Collapsable extends Component {
        boolean isExpanded();
        void setExpanded(boolean expanded);

        boolean isCollapsable();
        void setCollapsable(boolean collapsable);

        @Deprecated
        void addListener(ExpandListener listener);
        @Deprecated
        void removeListener(ExpandListener listener);

        @Deprecated
        void addListener(CollapseListener listener);
        @Deprecated
        void removeListener(CollapseListener listener);

        @Deprecated
        interface ExpandListener {
            void onExpand(Collapsable component);
        }

        @Deprecated
        interface CollapseListener {
            void onCollapse(Collapsable component);
        }

        void addExpandedStateChangeListener(ExpandedStateChangeListener listener);
        void removeExpandedStateChangeListener(ExpandedStateChangeListener listener);
    }

    interface Disposable {
        void dispose();
        boolean isDisposed();
    }

    /**
     * Component supporting an action
     */
    interface ActionOwner {
        Action getAction();
        void setAction(Action action);
    }

    /**
     * Component having an icon
     */
    interface HasIcon {
        String getIcon();
        void setIcon(String icon);
    }

    interface HasButtonsPanel {
        ButtonsPanel getButtonsPanel();
        void setButtonsPanel(ButtonsPanel panel);
    }

    /**
     * A component which can be validated
     */
    interface Validatable {
        boolean isValid();
        void validate() throws ValidationException;
    }

    interface HasPresentations extends HasSettings {
        void usePresentations(boolean b);
        boolean isUsePresentations();

        void resetPresentation();
        void loadPresentations();

        Presentations getPresentations();

        void applyPresentation(Object id);
        void applyPresentationAsDefault(Object id);

        Object getDefaultPresentationId();
    }

    interface Spacing {
        void setSpacing(boolean enabled);
    }

    interface Margin {
        void setMargin(boolean enable);
        void setMargin(boolean topEnable, boolean rightEnable, boolean bottomEnable, boolean leftEnable);
    }

    interface HasInputPrompt {
        /**
         * @return current input prompt.
         */
        String getInputPrompt();

        /**
         * Sets the input prompt - a textual prompt that is displayed when the field
         * would otherwise be empty, to prompt the user for input.
         *
         * @param inputPrompt input prompt
         */
        void setInputPrompt(String inputPrompt);
    }

    /**
     * State of subcomponents can be managed by UI permissions.
     */
    interface UiPermissionAware {

        /**
         * Change state of subcomponent according to the {@code permissionValue}.
         *
         * @param permissionDescriptor descriptor which contains id of subcomponent and UI permission value
         *                             which will be applied to this subcomponent or ids of subcomponent and its action
         *                             and UI permission value which will be applied to subcomponent's action
         */
        void applyPermission(UiPermissionDescriptor permissionDescriptor);
    }
}