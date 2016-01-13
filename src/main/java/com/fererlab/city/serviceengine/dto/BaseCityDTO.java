package com.fererlab.city.serviceengine.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class BaseCityDTO<T> implements CityDTO<T> {

    private String countryName;

    private String name;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
