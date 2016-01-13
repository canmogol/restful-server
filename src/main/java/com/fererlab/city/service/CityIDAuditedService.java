package com.fererlab.city.service;

import com.fererlab.core.service.BaseService;
import com.fererlab.city.model.CityIDAudited;

import javax.ejb.Local;

@Local
public interface CityIDAuditedService extends BaseService<CityIDAudited, Integer> {

    CityIDAudited findByCountryName(String countryName);

}
