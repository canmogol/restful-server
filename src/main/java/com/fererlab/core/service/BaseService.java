package com.fererlab.core.service;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

@Local
public interface BaseService<T extends Serializable, PK>
{
    void create(T t);

    void update(T t);

    void delete(PK id);

    T findById(PK id);

    List<T> list();

    List<T> list(final Integer index, final Integer numberOfRecords);

    PK count();
}
