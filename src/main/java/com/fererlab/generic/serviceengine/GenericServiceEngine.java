package com.fererlab.generic.serviceengine;


import com.fererlab.core.model.Model;
import com.fererlab.generic.dto.BaseDTO;

import javax.ejb.Local;

@Local
public interface GenericServiceEngine<D extends BaseDTO<PK>, T extends Model<?>, PK> {

    D find(PK id, Class<T> entityClass, Class<D> dtoClass);

    D create(D dto, Class<T> entityClass, Class<D> dtoClass);

    D update(D dto, Class<T> entityClass, Class<D> dtoClass);

    D delete(PK id, Class<T> entityClass, Class<D> dtoClass);

}
