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

package com.haulmont.cuba.core.app.cache;

import com.haulmont.bali.datastruct.Pair;
import org.apache.commons.collections4.Predicate;

import java.util.Collection;

/**
 * Objects cache interface.
 *
 * @deprecated Will be removed in release 7.0
 */
@Deprecated
public interface ObjectsCacheInstance {
    String getName();

    CacheStatistics getStatistics();

    Collection execute(CacheSelector cacheSelector);

    int count(Predicate... selectors);

    Pair<Integer, Integer> count(Collection<Predicate> selectors, Predicate amplifyingSelector);
}
