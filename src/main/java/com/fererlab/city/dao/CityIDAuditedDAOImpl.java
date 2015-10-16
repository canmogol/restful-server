package com.fererlab.city.dao;

import com.fererlab.city.model.CityIDAudited;
import com.fererlab.core.dao.AbstractDAO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "CityIDAuditedDAOImpl", mappedName = "CityIDAuditedDAOImpl")
@Local(CityIDAuditedDAO.class)
public class CityIDAuditedDAOImpl extends AbstractDAO<CityIDAudited, Long> implements CityIDAuditedDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
