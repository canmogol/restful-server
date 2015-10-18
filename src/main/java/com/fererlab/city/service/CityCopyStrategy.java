package com.fererlab.city.service;

import com.fererlab.city.model.City;
import com.fererlab.city.serviceengine.dto.BaseCityDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless(name = "CityCopyStrategy", mappedName = "CityCopyStrategy")
@LocalBean
public class CityCopyStrategy {

    @SuppressWarnings("unchecked")
    public <T extends BaseCityDTO> void copy(City entity, T dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
    }

}
