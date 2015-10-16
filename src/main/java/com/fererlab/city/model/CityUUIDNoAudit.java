package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelUUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CITY_UUID_NO_AUDIT")
@XmlRootElement
public class CityUUIDNoAudit extends BaseModelUUID {

    private static final long serialVersionUID = 3843775841330855480L;

    private String name;

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

}
