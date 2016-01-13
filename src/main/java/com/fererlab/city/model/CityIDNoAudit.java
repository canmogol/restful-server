package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "CITY_ID_NO_AUDIT")
public class CityIDNoAudit extends BaseModelID<Long> implements City<Long>{

    private static final long serialVersionUID = 3095959829066806345L;

    private String name;

    private String countryName;

    public CityIDNoAudit() {
    }

    public CityIDNoAudit(String name) {
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
