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

package com.haulmont.cuba.restapi;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * OAuth token store for the REST API.
 */
public interface ServerTokenStore {

    String NAME = "cuba_ServerTokenStore";

    byte[] getAccessTokenByAuthentication(String authenticationKey);

    void storeAccessToken(String tokenValue, byte[] accessTokenBytes, String authenticationKey, byte[] authenticationBytes, Date tokenExpiry);

    byte[] getAccessTokenByTokenValue(String tokenValue);

    byte[] getAuthenticationByTokenValue(String tokenValue);

    UUID getSessionIdByTokenValue(String authenticationKey);

    UUID putSessionId(String authenticationKey, UUID sessionId);

    void removeAccessToken(String tokenValue);

    void deleteExpiredTokens();

    /**
     * Finds tokens with attribute with name {@code attributeName} and value equal to passed {@code attributeValue}.
     *
     * @param attributeName attribute name
     * @param attributeValue attribute value
     * @return token ids
     */
    List<String> findTokensByAttribute(String attributeName, Object attributeValue);
}