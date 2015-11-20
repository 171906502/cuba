/*
 * Copyright (c) 2008-2015 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.core.sys;

import com.haulmont.cuba.core.PersistenceSecurity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.testsupport.TestContainer;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

/**
 * @author degtyarjov
 * @version $Id$
 */
public class PersistenceSecurityImplTest {

    @ClassRule
    public static TestContainer testContainer = TestContainer.Common.INSTANCE;

    @Test
    public void testSecurityToken() throws Exception {
        SecurityTokenManager persistenceSecurity = AppBeans.get(SecurityTokenManager.class);
        User user = new User();
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        UUID id4 = UUID.randomUUID();
        user.__addFiltered("userRoles", id1);
        user.__addFiltered("userRoles", id2);
        user.__addFiltered("userRoles", id3);
        user.__addFiltered("userRoles", id4);

        persistenceSecurity.writeSecurityToken(user);
        persistenceSecurity.readSecurityToken(user);

        List<UUID> userRoles = (List<UUID>) user.__getFilteredData().get("userRoles");
        Assert.assertEquals(4, userRoles.size());
        Assert.assertEquals(id1, userRoles.get(0));
        Assert.assertEquals(id2, userRoles.get(1));
        Assert.assertEquals(id3, userRoles.get(2));
        Assert.assertEquals(id4, userRoles.get(3));
    }
}
