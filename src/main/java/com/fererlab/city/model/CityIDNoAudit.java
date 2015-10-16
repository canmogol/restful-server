package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "CITY_ID_NO_AUDIT")
@XmlRootElement
public class CityIDNoAudit extends BaseModelID<Long> {

    private static final long serialVersionUID = 3095959829066806345L;

    private String name;

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

}
