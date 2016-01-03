package com.fererlab.core.dao;

import com.fererlab.core.model.BaseModel;
import com.fererlab.core.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class AbstractDAO<T extends Serializable, PK> implements BaseDAO<T, PK> {

    private Class<T> entityClass;

    public abstract EntityManagerFactory getEntityManagerFactory();

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        if (this instanceof GenericDAO) {
            entityClass = (Class<T>) Model.class;
        } else {
            entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T t) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.persist(t);
    }

    @Override
    public void update(T t) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        if (!entityManager.contains(t)) {
            t = entityManager.merge(t);
        }
        if (t instanceof BaseModel) {
            ((BaseModel) t).setDeleted(Boolean.TRUE);
            entityManager.merge(t);
        } else {
            entityManager.remove(t);
        }
    }

    @Override
    public void delete(PK id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        T t = entityManager.getReference(entityClass, id);
        if (t instanceof BaseModel) {
            ((BaseModel) t).setDeleted(Boolean.TRUE);
            entityManager.merge(t);
        } else {
            entityManager.remove(t);
        }
    }

    @Override
    public T findById(PK id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        T t = entityManager.find(entityClass, id);
        if (t != null && t instanceof BaseModel && ((BaseModel) t).isDeleted()) {
            // this entity is marked as deleted, return null
            return null;
        }
        return t;
    }

    @Override
    public List<T> list() {
        // What kind of a method is this "list" method? shouldn't it has some sort of a limit?
        // Hibernate implementation also thinks in the same way:
        // org.hibernate.ejb.AbstractQueryImpl   getMaxResults(){
        //      return maxResults == -1
        //          ? Integer.MAX_VALUE // stupid spec... MAX_VALUE??
        //          : maxResults;
        // }
        return list(0, Integer.MAX_VALUE);
    }

    @Override
    public List<T> list(Integer index, Integer numberOfRecords) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        if (BaseModel.class.isAssignableFrom(entityClass)) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("deleted"), Boolean.FALSE));
        }
        criteriaQuery.select(root);
        List<T> list = entityManager.createQuery(criteriaQuery).setFirstResult(index).setMaxResults(numberOfRecords)
                .getResultList();
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long count() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> root = criteriaQuery.from(entityClass);
        if (BaseModel.class.isAssignableFrom(entityClass)) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("deleted"), Boolean.FALSE));
        }
        criteriaQuery.select(criteriaBuilder.count(root));
        TypedQuery<Long> query = entityManager.createQuery(criteriaQuery);
        Long count = query.getSingleResult();
        return count;
    }

}
