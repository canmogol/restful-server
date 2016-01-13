package com.fererlab.city.serviceengine.dto;

public interface CityDTO<T> {

    T getId();

    void setId(T t);

    String getName();

    void setName(String name);

    String getCountryName();

    void setCountryName(String countryName);

}
