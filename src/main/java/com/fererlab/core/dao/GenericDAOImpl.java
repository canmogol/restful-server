package com.fererlab.core.dao;

import com.fererlab.core.model.Model;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Stateless(name = "GenericDAOImpl", mappedName = "GenericDAOImpl")
public class GenericDAOImpl<T extends Model<?>, PK> extends AbstractDAO<T, PK> implements GenericDAO<T, PK> {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public void delete(Class<T> t, PK id) {
        super.setEntityClass(t);
        super.delete(id);
    }

    @Override
    public T findById(Class<T> t, PK id) {
        super.setEntityClass(t);
        return super.findById(id);
    }

    @Override
    public List<T> list(Class<T> t) {
        super.setEntityClass(t);
        return super.list();
    }

    @Override
    public List<T> list(Class<T> t, Integer index, Integer numberOfRecords) {
        super.setEntityClass(t);
        return super.list(index, numberOfRecords);
    }

    @Override
    public Long count(Class<T> t) {
        super.setEntityClass(t);
        return super.count();
    }

}
