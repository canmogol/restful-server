package com.fererlab.core.service;

import com.fererlab.core.dao.GenericDAO;
import com.fererlab.core.model.BaseModel;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GenericService<T extends BaseModel<?>, PK>{

    GenericDAO<T, PK> getBaseDAO();

    void create(T t);

    void update(T t);

    void delete(T t);

    void delete(Class<T> t, PK id);

    T findById(Class<T> t, PK id);

    List<T> list(Class<T> t);

    List<T> list(Class<T> t, final Integer index, final Integer numberOfRecords);

    PK count(Class<T> t);

}
