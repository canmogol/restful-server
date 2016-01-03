package com.fererlab.core.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@MappedSuperclass
public abstract class BaseModelOID extends BaseModel<String> {

    private static final long serialVersionUID = -8972332672554682948L;

    private String id = null;

    public BaseModelOID(String id) {
        this.id = id;
    }

    protected BaseModelOID() {
    }

    @Id
    @Column(name = "BMOID_OID", updatable = false, nullable = false)
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

}
