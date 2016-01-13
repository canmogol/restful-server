package com.fererlab.city.service;

import com.fererlab.city.model.City;
import com.fererlab.city.model.CityIDAudited;
import com.fererlab.city.serviceengine.dto.BaseCityDTO;
import com.fererlab.city.serviceengine.dto.CityIdIntegerDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "CityCopyStrategy", mappedName = "CityCopyStrategy")
@LocalBean
public class CityCopyStrategy {

    @SuppressWarnings("unchecked")
    public <T extends BaseCityDTO> void copy(City from, T to) {
        to.setId(from.getId());
        to.setName(from.getName());
        to.setCountryName(from.getCountryName());
    }

    public void copy(List<CityIDAudited> fromList, List<CityIdIntegerDTO> toList) {
        for(CityIDAudited from : fromList){
            CityIdIntegerDTO to = new CityIdIntegerDTO();
            copy(from, to);
            toList.add(to);
        }
    }
}
