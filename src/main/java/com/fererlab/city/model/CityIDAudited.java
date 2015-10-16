package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelIDAudited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CITY_ID_AUDITED")
@XmlRootElement
public class CityIDAudited extends BaseModelIDAudited<Integer> {

    private static final long serialVersionUID = -5819948978970016787L;

    private String name;

    public CityIDAudited() {
    }

    public CityIDAudited(String name) {
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
