package com.pss.alcs.atlassian.dao;

/**
 * Abstract Class for DAO Operations
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Object save(Object entity) {
        getSession().persist(entity);
        return entity;
    }

    public Object update(Object entity) {
        getSession().update(entity);
        return entity;
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
