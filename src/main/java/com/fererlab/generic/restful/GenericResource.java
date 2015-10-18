package com.fererlab.generic.restful;

import com.fererlab.core.model.BaseModel;
import com.fererlab.generic.dto.BaseDTO;
import com.fererlab.generic.serviceengine.GenericServiceEngine;

import javax.ejb.EJB;

public abstract class GenericResource<D extends BaseDTO<PK>, T extends BaseModel<?>, PK extends Number> {

    @EJB(name = "GenericServiceEngineImpl")
    private GenericServiceEngine<D, T, PK> genericServiceEngine;

    private final Class<T> entityClass;
    private final Class<D> dtoClass;

    public GenericResource(Class<T> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    protected D _find(PK id) {
        return genericServiceEngine.find(id, entityClass, dtoClass);
    }

    protected D _create(D dto) {
        return genericServiceEngine.create(dto, entityClass, dtoClass);
    }

    protected D _update(D dto) {
        return genericServiceEngine.update(dto, entityClass, dtoClass);
    }

    protected D _delete(PK id) {
        return genericServiceEngine.delete(id, entityClass, dtoClass);
    }

}
