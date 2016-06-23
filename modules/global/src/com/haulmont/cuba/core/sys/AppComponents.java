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
 */

package com.haulmont.cuba.core.sys;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.haulmont.bali.util.Dom4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.jar.Manifest;

/**
 * Holds the list of {@link AppComponent}s.
 */
public class AppComponents {

    private Logger log = LoggerFactory.getLogger(AppComponents.class);

    private final List<AppComponent> components = new ArrayList<>();

    private Map<String, String> componentIdsToDescriptors;

    private String block;

    /**
     * This constructor is used when no app components are specified.
     * @param block current application block (core, web, etc.)
     */
    public AppComponents(String block) {
        this.block = block;
    }

    /**
     * This constructor is used in runtime when component descriptors are discovered from JAR manifests.
     * @param componentIds  identifiers of components to be used
     * @param block         current application block (core, web, etc.)
     */
    public AppComponents(List<String> componentIds, String block) {
        this(block);
        loadAll(componentIds);
    }

    /**
     * This constructor is used in tests when component descriptors should be provided explicitly.
     * @param componentIdsToDescriptors map of component identifiers to descriptor paths
     * @param block                     current application block (core, web, etc.)
     */
    public AppComponents(Map<String, String> componentIdsToDescriptors, String block) {
        this(block);
        this.componentIdsToDescriptors = componentIdsToDescriptors;
        loadAll(componentIdsToDescriptors.keySet());
    }

    private void loadAll(Collection<String> componentIds) {
        for (String compId : componentIds) {
            AppComponent component = get(compId);
            if (component == null) {
                component = new AppComponent(compId);
                load(component);
            }
            if (!components.contains(component))
                components.add(component);
        }
        Collections.sort(components);
        log.info("Using app components: " + components);
    }

    /**
     * @return the name of the current application block
     */
    public String getBlock() {
        return block;
    }

    /**
     * @return the list of app components
     */
    public List<AppComponent> getComponents() {
        return Collections.unmodifiableList(components);
    }

    /**
     * Get an app component by Id.
     * @return app component or null if not found
     */
    @Nullable
    public AppComponent get(String componentId) {
        for (AppComponent component : components) {
            if (component.getId().equals(componentId))
                return component;
        }
        return null;
    }

    private void load(AppComponent component) {
        try {
            Document doc = getDescriptorDoc(component);

            String dependsOnAttr = doc.getRootElement().attributeValue("dependsOn");
            if (!StringUtils.isEmpty(dependsOnAttr)) {
                for (String depCompId : splitCommaSeparatedValue(dependsOnAttr)) {
                    AppComponent depComp = get(depCompId);
                    if (depComp == null) {
                        depComp = new AppComponent(depCompId);
                        load(depComp);
                        components.add(depComp);
                    }
                    component.addDependency(depComp);
                }
            }

            for (Element moduleEl : Dom4j.elements(doc.getRootElement(), "module")) {
                String blocksAttr = moduleEl.attributeValue("blocks");
                if (StringUtils.isEmpty(blocksAttr))
                    continue;
                List<String> blocks = splitCommaSeparatedValue(blocksAttr);
                if (blocks.contains("*") || blocks.contains(block)) {
                    for (Element propertyEl : Dom4j.elements(moduleEl, "property")) {
                        String name = propertyEl.attributeValue("name");
                        String value = propertyEl.attributeValue("value");
                        String existingValue = component.getProperty(name);
                        if (existingValue != null) {
                            String newValue = existingValue;
                            Splitter splitter = Splitter.on(AppProperties.SEPARATOR_PATTERN).omitEmptyStrings();
                            List<String> existingParts = splitter.splitToList(existingValue);
                            for (String part : splitter.split(value)) {
                                if (!existingParts.contains(part))
                                    newValue += " " + part;
                            }
                            component.setProperty(name, newValue);
                        } else {
                            component.setProperty(name, value);
                        }
                    }
                }

            }
        } catch (IOException | DocumentException e) {
            throw new RuntimeException("Error loading app component '" + component + "'", e);
        }
    }

    private Document getDescriptorDoc(AppComponent component) throws IOException, DocumentException {
        Document doc = null;
        SAXReader reader = new SAXReader();

        if (componentIdsToDescriptors != null) {
            for (String descriptorPath : componentIdsToDescriptors.values()) {
                InputStream descrStream = getClass().getClassLoader().getResourceAsStream(descriptorPath);
                if (descrStream == null)
                    throw new RuntimeException("App component descriptor was not found in '" + descriptorPath + "'");
                Document descrDoc;
                try {
                    descrDoc = reader.read(new InputStreamReader(descrStream, StandardCharsets.UTF_8));
                } catch (DocumentException e) {
                    throw new RuntimeException("Error reading app component descriptor '" + descriptorPath + "'", e);
                } finally {
                    IOUtils.closeQuietly(descrStream);
                }
                if (component.getId().equals(descrDoc.getRootElement().attributeValue("id"))) {
                    doc = descrDoc;
                    log.debug("Loading app component descriptor '{}'", descriptorPath);
                    break;
                }
            }
        } else {
            Enumeration<URL> manifests = getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (manifests.hasMoreElements()) {
                Manifest man;
                InputStream manStream = manifests.nextElement().openStream();
                try {
                    man = new Manifest(manStream);
                } finally {
                    IOUtils.closeQuietly(manStream);
                }
                String descriptorPath = man.getMainAttributes().getValue(AppComponent.ATTR_DESCR);
                if (!Strings.isNullOrEmpty(descriptorPath)) {
                    InputStream descrStream = getClass().getClassLoader().getResourceAsStream(descriptorPath);
                    if (descrStream == null)
                        throw new RuntimeException("App component descriptor was not found in '" + descriptorPath + "'");
                    Document descrDoc;
                    try {
                        descrDoc = reader.read(new InputStreamReader(descrStream, StandardCharsets.UTF_8));
                    } finally {
                        IOUtils.closeQuietly(descrStream);
                    }
                    if (component.getId().equals(descrDoc.getRootElement().attributeValue("id"))) {
                        doc = descrDoc;
                        log.debug("Loading app component descriptor '{}'", descriptorPath);
                        break;
                    }
                }
            }
        }

        if (doc == null)
            throw new RuntimeException("App component '" + component +"' was not found on the classpath");
        return doc;
    }

    private List<String> splitCommaSeparatedValue(String value) {
        return Splitter.on(',').omitEmptyStrings().trimResults().splitToList(value);
    }
}
