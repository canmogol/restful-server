package com.fererlab.city.dao;

import com.fererlab.city.model.CityIDAudited;
import com.fererlab.core.dao.AbstractDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

@Stateless(name = "CityIDAuditedDAOImpl", mappedName = "CityIDAuditedDAOImpl")
public class CityIDAuditedDAOImpl extends AbstractDAO<CityIDAudited, Integer> implements CityIDAuditedDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    public CityIDAudited findByCountryName(String countryName) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        TypedQuery<CityIDAudited> query = entityManager.createQuery("select c from CityIDAudited c where c.countryName =:countryName", CityIDAudited.class);
        return query.getSingleResult();
    }
}
