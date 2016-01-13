package com.fererlab.country.service;

import com.fererlab.city.serviceengine.CityServiceEngine;
import com.fererlab.country.serviceengine.CountryServiceEngine;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "CountryServiceEngineImpl", mappedName = "CountryServiceEngineImpl")
public class CountryServiceEngineImpl implements CountryServiceEngine {

    @EJB(beanName = "CityServiceSelector")
    private CityServiceSelector serviceSelector;

    @Override
    public String findCapitolName(String countryName) {
        CityServiceEngine cityServiceEngine = serviceSelector.select();
        return cityServiceEngine.findCityWithCountryName(countryName).getName();
    }
}
