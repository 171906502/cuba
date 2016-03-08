/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.core.config.type;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class IntegerListStringify extends TypeStringify {

    @SuppressWarnings("unchecked")
    @Override
    public String stringify(Object value) {
        return ((List<Integer>) value).stream().map(String::valueOf).collect(Collectors.joining("|"));
    }
}
