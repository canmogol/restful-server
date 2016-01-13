package com.fererlab.country.service;

import com.fererlab.city.serviceengine.CityServiceEngine;
import com.fererlab.core.selector.ServiceSelector;

import javax.ejb.Stateless;

@Stateless(name = "CityServiceSelector", mappedName = "CityServiceSelector")
public class CityServiceSelector extends ServiceSelector<CityServiceEngine> {
}
