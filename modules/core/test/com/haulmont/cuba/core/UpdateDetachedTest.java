/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.cuba.core;

import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.security.entity.Permission;
import com.haulmont.cuba.security.entity.PermissionType;
import com.haulmont.cuba.security.entity.Role;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

import static com.haulmont.cuba.testsupport.TestSupport.reserialize;

/**
 * @author krivopustov
 * @version $Id$
 */
public class UpdateDetachedTest extends CubaTestCase {

    private UUID roleId, role2Id, permissionId;

    protected void setUp() throws Exception {
        super.setUp();
        Transaction tx = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();

            Role role = new Role();
            roleId = role.getId();
            role.setName("testRole");
            em.persist(role);

            Role role2 = new Role();
            role2Id = role2.getId();
            role2.setName("testRole2");
            em.persist(role2);

            Permission permission = new Permission();
            permissionId = permission.getId();
            permission.setRole(role);
            permission.setType(PermissionType.SCREEN);
            permission.setTarget("testTarget");
            em.persist(permission);

            tx.commit();
        } finally {
            tx.end();
        }
    }

    protected void tearDown() throws Exception {
        Transaction tx = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();

            Query q;
            q = em.createNativeQuery("delete from SEC_PERMISSION where ID = ?");
            q.setParameter(1, permissionId.toString());
            q.executeUpdate();

            q = em.createNativeQuery("delete from SEC_ROLE where ID = ? or ID = ?");
            q.setParameter(1, roleId.toString());
            q.setParameter(2, role2Id.toString());
            q.executeUpdate();

            tx.commit();
        } finally {
            tx.end();
        }
        super.tearDown();
    }

    public void test() throws Exception {
        Permission p;
        Transaction tx = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();

            View view = new View(Permission.class)
                    .addProperty("target")
                    .addProperty("role",
                            new View(Role.class)
                                    .addProperty("name")
                    );

            p = em.find(Permission.class, permissionId, view);
            tx.commitRetaining();

            assertNotNull(p);
            p.setTarget("newTarget");

            em = persistence.getEntityManager();
            p = em.merge(p);

            tx.commit();
        } finally {
            tx.end();
        }
        p = reserialize(p);
        assertTrue(PersistenceHelper.isDetached(p));
        assertNotNull(p.getRole());
        assertTrue(PersistenceHelper.isDetached(p.getRole()));
        assertTrue(PersistenceHelper.isLoaded(p, "role"));
    }

    public void testRollback() {
        Permission p = null;
        Transaction tx = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();

            View view = new View(Permission.class)
                    .addProperty("target")
                    .addProperty("role",
                            new View(Role.class)
                                    .addProperty("name")
                    );

            p = em.find(Permission.class, permissionId, view);
            tx.commitRetaining();

            p.setTarget("newTarget");

            em = persistence.getEntityManager();
            p = em.merge(p);

            throwException();
            tx.commit();
        } catch (RuntimeException e) {
            // ok
        } finally {
            tx.end();
            assertNotNull(p);
//            assertNull(((PersistenceCapable) p).pcGetDetachedState());
        }
    }

    private void throwException() {
        throw new RuntimeException();
    }

    public void testDataService() throws Exception {
        Permission p;
        DataService ds = AppBeans.get(DataService.NAME);

        LoadContext ctx = new LoadContext(Permission.class);
        ctx.setId(permissionId);
        ctx.setView(new View(Permission.class)
                .addProperty("target")
                .addProperty("role",
                    new View(Role.class)
                        .addProperty("name")
                )
        );
        p = ds.load(ctx);

        assertNotNull(p);
        p.setTarget("newTarget");

        CommitContext commitCtx = new CommitContext(Collections.singleton(p));
        Set<Entity> entities = ds.commit(commitCtx);

        Permission result = null;
        for (Entity entity : entities) {
            if (entity.equals(p))
                result = (Permission) entity;
        }
        result = reserialize(result);
        assertTrue(PersistenceHelper.isDetached(result));
        assertNotNull(result.getRole());
        assertTrue(PersistenceHelper.isDetached(result.getRole()));
        assertTrue(PersistenceHelper.isLoaded(result, "role"));
    }

    public void testUpdateNotLoaded() throws Exception {
        Permission p;
        Role role;
        Transaction tx = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();

            p = em.find(Permission.class, permissionId, new View(Permission.class).addProperty("target"));
            tx.commitRetaining();

            em = persistence.getEntityManager();
            role = em.find(Role.class, role2Id);
            tx.commit();
        } finally {
            tx.end();
        }
        p = reserialize(p);

        assertFalse(PersistenceHelper.isLoaded(p, "role"));
        assertFalse(PersistenceHelper.isLoaded(p, "value"));
    }
}
