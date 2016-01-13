package com.fererlab.city.serviceengine.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CityIdIntegerDTO extends BaseCityDTO<Integer> {

    private Integer id;

    public CityIdIntegerDTO() {
    }

    public CityIdIntegerDTO(String cityName, String countryName) {
        setName(cityName);
        setCountryName(countryName);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
