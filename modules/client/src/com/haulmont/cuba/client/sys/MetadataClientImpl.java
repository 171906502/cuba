/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.cuba.client.sys;

import com.haulmont.bali.util.ReflectionHelper;
import com.haulmont.chile.core.loader.ChileMetadataLoader;
import com.haulmont.chile.core.loader.MetadataLoader;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.Session;
import com.haulmont.cuba.client.ClientConfig;
import com.haulmont.cuba.core.app.ServerInfoService;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.core.sys.AbstractMetadata;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.PersistentClassesMetadataLoader;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrTokenizer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>$Id$</p>
 *
 * @author krivopustov
 */
@ManagedBean(Metadata.NAME)
public class MetadataClientImpl extends AbstractMetadata {

    private Log log = LogFactory.getLog(getClass());

    @Inject
    private ServerInfoService serverInfoService;

    @Inject
    private Configuration configuration;

    @Override
    protected void initMetadata() {
        log.info("Initializing metadata");

        MetadataBuildInfo metadataBuildInfo = serverInfoService.getMetadataBuildInfo();

        Collection<String> packages;

        MetadataLoader metadataLoader = new PersistentClassesMetadataLoader();
        packages = metadataBuildInfo.getPersistentEntitiesPackages();
        loadMetadata(metadataLoader, packages);
        metadataLoader.postProcess();

        Session session = metadataLoader.getSession();

        metadataLoader = new ChileMetadataLoader(session);
        packages = metadataBuildInfo.getTransientEntitiesPackages();
        loadMetadata(metadataLoader, packages);
        metadataLoader.postProcess();

        for (Map.Entry<String, Map<String, Object>> classEntry : metadataBuildInfo.getEntityAnnotations().entrySet()) {
            MetaClass metaClass = session.getClass(ReflectionHelper.getClass(classEntry.getKey()));
            for (Map.Entry<String, Object> entry : classEntry.getValue().entrySet()) {
                metaClass.getAnnotations().put(entry.getKey(), entry.getValue());
            }
        }

        Map<Class, Class> replacedEntities = new HashMap<Class, Class>();
        for (Map.Entry<String, String> entry : metadataBuildInfo.getReplacedEntities().entrySet()) {
            Class from = ReflectionHelper.getClass(entry.getKey());
            Class to = ReflectionHelper.getClass(entry.getValue());
            replacedEntities.put(from, to);
        }

        this.session = session;
        this.replacedEntities = replacedEntities;
    }

    @Override
    protected void initViews() {
        log.info("Initializing views");

        boolean lazyLoadServerViews = configuration.getConfig(ClientConfig.class).getLazyLoadServerViews();

        ViewRepositoryClient viewRepository = new ViewRepositoryClient(lazyLoadServerViews, serverInfoService);

        if (!lazyLoadServerViews) {
            List<View> views = serverInfoService.getViews();
            for (View view : views) {
                MetaClass metaClass = getSession().getClass(view.getEntityClass());
                viewRepository.storeView(metaClass, view);
            }
        }

        String configName = AppContext.getProperty("cuba.viewsConfig");
        if (!StringUtils.isBlank(configName)) {
            StrTokenizer tokenizer = new StrTokenizer(configName);
            for (String fileName : tokenizer.getTokenArray()) {
                viewRepository.deployViews(fileName);
            }
        }

        this.viewRepository = viewRepository;
    }
}
