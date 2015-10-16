package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelUUIDAudited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "CITY_UUID_AUDITED")
@XmlRootElement
public class CityUUIDAudited extends BaseModelUUIDAudited {

    private static final long serialVersionUID = 3067677577698971294L;

    private String name;

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

}