package com.fererlab.city.service;

import com.fererlab.city.model.City;
import com.fererlab.city.serviceengine.dto.BaseCityDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless(name = "CopyStrategy", mappedName = "CopyStrategy")
@LocalBean
public class CopyStrategy {

//    public CityIdIntegerDTO copy(City<Integer> entity, CityIdIntegerDTO dto) {
//        dto.setId(entity.getId());
//        dto.setName(entity.getName());
//        return dto;
//    }
//
//    public CityIdLongDTO copy(City<Long> entity, CityIdLongDTO dto) {
//        dto.setId(entity.getId());
//        dto.setName(entity.getName());
//        return dto;
//    }

    @SuppressWarnings("unchecked")
    public <T extends BaseCityDTO> T copy(City entity, T dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
