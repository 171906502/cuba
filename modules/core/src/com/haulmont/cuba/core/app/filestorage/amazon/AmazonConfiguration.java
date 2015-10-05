/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.core.app.filestorage.amazon;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;

/**
 * @author degtyarjov
 * @version $Id$
 */
public interface AmazonConfiguration extends Config {
    @Property("amazon.s3.accessKey")
    String getAccessKey();

    @Property("amazon.s3.secretAccessKey")
    String getSecretAccessKey();

    @Property("amazon.s3.region")
    String getRegionName();

    @Property("amazon.s3.bucket")
    String getBucket();
}
