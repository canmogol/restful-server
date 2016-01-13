package com.fererlab.country.service;

import com.fererlab.city.serviceengine.CityServiceEngine;
import com.fererlab.city.serviceengine.dto.CityIdIntegerDTO;
import com.fererlab.country.serviceengine.CountryServiceEngine;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "CountryServiceEngineImpl", mappedName = "CountryServiceEngineImpl")
public class CountryServiceEngineImpl implements CountryServiceEngine {

    @EJB(beanName = "CityServiceSelector")
    private CityServiceSelector serviceSelector;

    @Override
    public String findCapitolName(String countryName) {
        // To test the selector, you could comment out the "@Stateless" annotation at the "CityServiceEngineImpl" class
        // By this way, CDI container will not be able to find the "@Default" qualifier annotated(explicitly or implicitly) implementation which is "CityServiceEngineImpl"
        // but it will find the one with "@MockServiceQualifier" annotated(explicitly) implementation which is "CityServiceEngineMockImpl" class
        CityServiceEngine cityServiceEngine = serviceSelector.select();
        CityIdIntegerDTO cityIdIntegerDTO = cityServiceEngine.findCityWithCountryName(countryName);
        // CityServiceEngineMockImpl returns "New York Mock" regardless of the countryName,
        // CityServiceEngineImpl returns whatever the result of the database query
        return cityIdIntegerDTO.getName();
    }
}
