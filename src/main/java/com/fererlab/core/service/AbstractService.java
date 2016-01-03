package com.fererlab.core.service;

import com.fererlab.core.dao.BaseDAO;

import java.io.Serializable;
import java.util.List;

/**
 * Session Bean implementation class BaseFacade
 */
public abstract class AbstractService<T extends Serializable, PK> implements
        BaseService<T, PK> {

    public abstract BaseDAO<T, PK> getBaseDAO();

    @Override
    public void create(T t) {
        getBaseDAO().create(t);
    }

    @Override
    public void update(T t) {
        getBaseDAO().update(t);
    }

    public void delete(T t) {
        getBaseDAO().delete(t);
    }

    @Override
    public void delete(PK id) {
        getBaseDAO().delete(id);
    }

    @Override
    public T findById(PK id) {
        return getBaseDAO().findById(id);
    }

    @Override
    public List<T> list() {
        return getBaseDAO().list();
    }

    @Override
    public List<T> list(Integer index, Integer numberOfRecords) {
        return getBaseDAO().list(index, numberOfRecords);
    }

    @Override
    public Long count() {
        return getBaseDAO().count();
    }

}
