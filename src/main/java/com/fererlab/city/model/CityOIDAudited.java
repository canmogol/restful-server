package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelOIDAudited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "CITY_OID_AUDITED")
@XmlRootElement
public class CityOIDAudited extends BaseModelOIDAudited {

    private static final long serialVersionUID = -2751402665525071933L;

    private String name;

    protected CityOIDAudited() {
    }

    public CityOIDAudited(String id) {
        super(id);
    }

    public CityOIDAudited(String id, String name) {
        super(id);
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
