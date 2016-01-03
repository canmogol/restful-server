package com.fererlab.core.dao;


import com.fererlab.core.model.Model;
import javax.ejb.Local;
import java.util.List;


@Local
public interface GenericDAO<T extends Model<?>, PK> {

    void create(T t);

    void update(T t);

    void delete(T t);

    void delete(Class<T> t, PK id);

    T findById(Class<T> t, PK id);

    List<T> list(Class<T> t);

    List<T> list(Class<T> t, final Integer index, final Integer numberOfRecords);

    Long count(Class<T> t);

}
