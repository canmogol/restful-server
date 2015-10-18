package com.fererlab.user.dao;

import com.fererlab.core.dao.AbstractDAO;
import com.fererlab.user.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "UserDAOImpl", mappedName = "UserDAOImpl")
public class UserDAOImpl extends AbstractDAO<User, Integer> implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
