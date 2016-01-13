package com.fererlab.city.model;

import com.fererlab.core.model.Model;

public interface City<T> extends Model<T> {

    String getName();

    void setName(String name);

    String getCountryName();

    void setCountryName(String countryName);

}
