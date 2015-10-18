package com.fererlab.generic.service;

import com.fererlab.core.model.BaseModel;
import com.fererlab.core.service.GenericService;
import com.fererlab.generic.dto.BaseDTO;
import com.fererlab.generic.serviceengine.GenericServiceEngine;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "GenericServiceEngineImpl", mappedName = "GenericServiceEngineImpl")
public class GenericServiceEngineImpl<D extends BaseDTO<PK>, T extends BaseModel<?>, PK> implements GenericServiceEngine<D, T, PK> {

    private Log log = LogFactory.getLog(GenericServiceEngineImpl.class);

    @EJB(name = "GenericCopyStrategy")
    private GenericCopyStrategy copyStrategy;

    @EJB(name = "GenericServiceImpl")
    private GenericService<T, PK> idService;

    @Override
    public D find(PK id, Class<T> entityClass, Class<D> dtoClass) {
        // find user by id
        T t = idService.findById(entityClass, id);
        // create and return a response dto
        D d = createDtoInstance(dtoClass);
        copyStrategy.copy(t, d);
        return d;
    }

    @Override
    public D create(D d, Class<T> entityClass, Class<D> dtoClass) {
        // create an empty entity
        T t = createEntityInstance(entityClass);
        // copy DTO to Entity
        copyStrategy.copy(d, t);
        // create an entity at db
        idService.create(t);
        // create and return a response dto
        d = createDtoInstance(dtoClass);
        copyStrategy.copy(t, d);
        return d;
    }

    @Override
    public D update(D d, Class<T> entityClass, Class<D> dtoClass) {
        // find user by id
        T t = idService.findById(entityClass, d.getId());
        // copy new user info to entity
        copyStrategy.copy(d, t);
        // update user entity
        idService.update(t);
        // create and return a response dto
        d = createDtoInstance(dtoClass);
        copyStrategy.copy(t, d);
        return d;
    }

    @Override
    public D delete(PK id, Class<T> entityClass, Class<D> dtoClass) {
        // find user by id
        T t = idService.findById(entityClass, id);
        // delete user entity
        idService.delete(t);
        // create and return a response dto
        D d = createDtoInstance(dtoClass);
        copyStrategy.copy(t, d);
        return d;
    }

    private D createDtoInstance(Class<D> dtoClass) {
        try {
            return dtoClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("could not create a new instance for class: " + dtoClass + " exception: " + e.getMessage());
            return null;
        }
    }

    private T createEntityInstance(Class<T> entityClass) {
        try {
            return entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("could not create a new instance for class: " + entityClass + " exception: " + e.getMessage());
            return null;
        }
    }


}
