package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelUUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CITY_UUID_NO_AUDIT")
public class CityUUIDNoAudit extends BaseModelUUID implements City<String> {

    private static final long serialVersionUID = 3843775841330855480L;

    private String name;

    private String countryName;

    public CityUUIDNoAudit() {
    }

    public CityUUIDNoAudit(String name) {
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
