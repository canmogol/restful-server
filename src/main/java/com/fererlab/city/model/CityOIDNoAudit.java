package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelOID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "CITY_OID_NO_AUDIT")
public class CityOIDNoAudit extends BaseModelOID implements City<String> {

    private static final long serialVersionUID = -628017012231816972L;

    private String name;

    protected CityOIDNoAudit() {
    }

    public CityOIDNoAudit(String id) {
        super(id);
    }

    public CityOIDNoAudit(String id, String name) {
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
