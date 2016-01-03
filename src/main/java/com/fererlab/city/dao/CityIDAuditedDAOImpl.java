package com.fererlab.city.dao;

import com.fererlab.city.model.CityIDAudited;
import com.fererlab.core.dao.AbstractDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless(name = "CityIDAuditedDAOImpl", mappedName = "CityIDAuditedDAOImpl")
public class CityIDAuditedDAOImpl extends AbstractDAO<CityIDAudited, Integer> implements CityIDAuditedDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
