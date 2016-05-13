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
package com.haulmont.cuba.web;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.client.ClientConfig;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.app.core.dev.LayoutAnalyzer;
import com.haulmont.cuba.gui.app.core.dev.LayoutTip;
import com.haulmont.cuba.gui.components.Frame;
import com.haulmont.cuba.gui.components.Window;
import com.haulmont.cuba.gui.components.mainwindow.UserIndicator;
import com.haulmont.cuba.gui.config.WindowConfig;
import com.haulmont.cuba.gui.config.WindowInfo;
import com.haulmont.cuba.gui.theme.ThemeConstantsRepository;
import com.haulmont.cuba.web.app.UserSettingsTools;
import com.haulmont.cuba.web.gui.components.mainwindow.WebAppWorkArea;
import com.haulmont.cuba.web.toolkit.ui.*;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.Extension;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Field;
import com.vaadin.ui.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.peter.contextmenu.ContextMenu;

import java.util.*;

/**
 * Standard main application window.
 * <p/>
 * To use a specific implementation override {@link App#createAppWindow(AppUI)} method.
 *
 */
public class AppWindow extends UIView implements CubaHistoryControl.HistoryBackHandler {

    private static final Logger log = LoggerFactory.getLogger(AppWindow.class);

    protected final AppUI ui;

    protected final App app;

    protected final Connection connection;

    protected final WebWindowManager windowManager;

    protected CubaClientManager clientManager;

    protected CubaFileDownloader fileDownloader;

    protected CubaHistoryControl historyControl;

    protected CubaTimer workerTimer;

    protected ScreenClientProfilerAgent clientProfiler;

    protected WebConfig webConfig;

    protected Window.MainWindow mainWindow;

    protected Messages messages = AppBeans.get(Messages.NAME);

    public AppWindow(AppUI ui) {
        log.trace("Creating " + this);

        this.ui = ui;
        this.app = ui.getApp();
        this.connection = app.getConnection();
        this.windowManager = createWindowManager();

        Configuration configuration = AppBeans.get(Configuration.NAME);
        webConfig = configuration.getConfig(WebConfig.class);

        setSizeFull();

        initInternalComponents();

        ClientConfig clientConfig = configuration.getConfig(ClientConfig.class);
        if (clientConfig.getLayoutAnalyzerEnabled()) {
            final ContextMenu contextMenu = new ContextMenu();
            contextMenu.setOpenAutomatically(true);
            ContextMenu.ContextMenuItem analyzeLayout = contextMenu.addItem(messages.getMainMessage("actions.analyzeLayout"));
            analyzeLayout.addItemClickListener(new ContextMenu.ContextMenuItemClickListener() {
                @Override
                public void contextMenuItemClicked(ContextMenu.ContextMenuItemClickEvent event) {
                    Window window = getMainWindow();
                    if (window != null) {
                        LayoutAnalyzer analyzer = new LayoutAnalyzer();
                        List<LayoutTip> tipsList = analyzer.analyze(window);

                        if (tipsList.isEmpty()) {
                            window.showNotification("No layout problems found", Frame.NotificationType.HUMANIZED);
                        } else {
                            window.openWindow("layoutAnalyzer", WindowManager.OpenType.DIALOG, ParamsMap.of("tipsList", tipsList));
                        }
                    }
                }
            });
            contextMenu.setAsContextMenuOf(this);

            addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
                @Override
                public void layoutClick(LayoutEvents.LayoutClickEvent event) {
                    if (event.getButton() == MouseEventDetails.MouseButton.RIGHT) {
                        Component targetComponent = event.getClickedComponent();

                        if (targetComponent != null
                                && targetComponent instanceof ComponentContainer
                                && !(targetComponent instanceof Field)) {
                            if (getMainWindow().getWorkArea() != null) {
                                WebAppWorkArea workArea = (WebAppWorkArea) getMainWindow().getWorkArea();
                                CubaTabSheet tabbedWindowContainer = workArea.getTabbedWindowContainer();
                                VerticalLayout singleWindowContainer = workArea.getSingleWindowContainer();

                                Component parent = targetComponent;
                                while (parent != null) {
                                    if (parent == tabbedWindowContainer
                                            || parent == singleWindowContainer) {
                                        return;
                                    }
                                    parent = parent.getParent();
                                }
                            }

                            contextMenu.open(event.getClientX(), event.getClientY());
                        }
                    }
                }
            });
        }
    }

    @Override
    public void show() {
        updateClientSystemMessages();

        beforeInitLayout();

        initAppMainWindow();
    }

    protected void initAppMainWindow() {
        WindowConfig windowConfig = AppBeans.get(WindowConfig.NAME);
        WindowInfo mainWindowInfo = windowConfig.getWindowInfo("mainWindow");
        windowManager.initMainWindow(mainWindowInfo);
    }

    public AppUI getAppUI() {
        return ui;
    }

    public WebWindowManager getWindowManager() {
        return windowManager;
    }

    /**
     * @return a new instance of {@link WebWindowManager}
     */
    protected WebWindowManager createWindowManager() {
        return new WebWindowManager(app, this);
    }

    /**
     * init system components
     */
    protected void initInternalComponents() {
        clientManager = new CubaClientManager();
        clientManager.extend(this);

        workerTimer = new CubaTimer();
        workerTimer.setTimerId("backgroundWorkerTimer");

        workerTimer.extend(this);

        workerTimer.setRepeating(true);
        workerTimer.setDelay(webConfig.getUiCheckInterval());
        workerTimer.start();

        fileDownloader = new CubaFileDownloader();
        fileDownloader.extend(this);

        clientProfiler = new ScreenClientProfilerAgent();
        clientProfiler.extend(this);

        if (webConfig.getAllowHandleBrowserHistoryBack()) {
            historyControl = new CubaHistoryControl();
            historyControl.extend(this, this);
        }
    }
    
    protected void updateClientSystemMessages() {
        CubaClientManager.SystemMessages msgs = new CubaClientManager.SystemMessages();
        UserSessionSource sessionSource = AppBeans.get(UserSessionSource.NAME);
        Locale locale = sessionSource.getLocale();

        msgs.communicationErrorCaption = messages.getMainMessage("communicationErrorCaption", locale);
        msgs.communicationErrorMessage = messages.getMainMessage("communicationErrorMessage", locale);

        msgs.sessionExpiredErrorCaption = messages.getMainMessage("sessionExpiredErrorCaption", locale);
        msgs.sessionExpiredErrorMessage = messages.getMainMessage("sessionExpiredErrorMessage", locale);

        msgs.authorizationErrorCaption = messages.getMainMessage("authorizationErrorCaption", locale);
        msgs.authorizationErrorMessage = messages.getMainMessage("authorizationErrorMessage", locale);

        clientManager.updateSystemMessagesLocale(msgs);
    }

    /**
     * Called when the user presses browser "Back" button and {@code cuba.web.allowHandleBrowserHistoryBack}
     * application property is true.
     * <p>Override this method and implement your logic to handle the "Back" button.
     */
    @Override
    public void onHistoryBackPerformed() {
    }

    @Override
    public String getTitle() {
        return getAppCaption();
    }

    public Window.MainWindow getMainWindow() {
        return mainWindow;
    }

    protected void setMainWindow(Window.MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * @return Application caption to be shown in browser page title
     */
    protected String getAppCaption() {
        return messages.getMainMessage("application.caption");
    }

    public CubaFileDownloader getFileDownloader() {
        return fileDownloader;
    }

    public CubaTimer getWorkerTimer() {
        return workerTimer;
    }

    public List<CubaTimer> getTimers() {
        List<CubaTimer> timers = new LinkedList<>();
        for (Extension extension : this.getExtensions()) {
            if (extension instanceof CubaTimer) {
                timers.add((CubaTimer) extension);
            }
        }
        return timers;
    }

    public void addTimer(CubaTimer timer) {
        if (!getExtensions().contains(timer)) {
            timer.extend(this);
        }
    }

    public void removeTimer(CubaTimer timer) {
        removeExtension(timer);
    }

    protected void beforeInitLayout() {
        // load theme from user settings
        String themeName = webConfig.getAppWindowTheme();
        UserSettingsTools userSettingsTools = AppBeans.get(UserSettingsTools.NAME);
        themeName = userSettingsTools.loadAppWindowTheme() == null ? themeName : userSettingsTools.loadAppWindowTheme();

        if (!Objects.equals(themeName, ui.getTheme())) {
            // check theme support
            ThemeConstantsRepository themeRepository = AppBeans.get(ThemeConstantsRepository.NAME);
            Set<String> supportedThemes = themeRepository.getAvailableThemes();
            if (supportedThemes.contains(themeName)) {
                app.applyTheme(themeName);
                ui.setTheme(themeName);
            }
        }
    }

    public void refreshUserSubstitutions() {
        UserIndicator userIndicator = getMainWindow().getUserIndicator();
        if (userIndicator != null) {
            userIndicator.refreshUserSubstitutions();
        }
    }
}