package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelUUIDAudited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "CITY_UUID_AUDITED")
public class CityUUIDAudited extends BaseModelUUIDAudited implements City<String> {

    private static final long serialVersionUID = 3067677577698971294L;

    private String name;

    private String countryName;

    public CityUUIDAudited() {
    }

    public CityUUIDAudited(String name) {
        this.name = name;
    }

    @Column(name = "CT_NAME", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CT_COUNTRY_NAME", length = 100, unique = true)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}