package com.fererlab.city.service;

import com.fererlab.city.dao.CityIDAuditedDAO;
import com.fererlab.city.model.CityIDAudited;
import com.fererlab.core.service.AbstractService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name="CityIDAuditedServiceImpl", mappedName = "CityIDAuditedServiceImpl")
public class CityIDAuditedServiceImpl extends AbstractService<CityIDAudited, Integer> implements CityIDAuditedService {

    @EJB(beanName = "CityIDAuditedDAOImpl")
    private CityIDAuditedDAO cityIDAuditedDAO;

    @Override
    public CityIDAuditedDAO getBaseDAO() {
        return cityIDAuditedDAO;
    }

    @Override
    public CityIDAudited findByCountryName(String countryName) {
        return getBaseDAO().findByCountryName(countryName);
    }
}
