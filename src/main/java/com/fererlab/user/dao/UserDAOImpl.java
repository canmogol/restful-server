package com.fererlab.user.dao;

import com.fererlab.core.dao.AbstractDAO;
import com.fererlab.user.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless(name = "UserDAOImpl", mappedName = "UserDAOImpl")
public class UserDAOImpl extends AbstractDAO<User, Integer> implements UserDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
