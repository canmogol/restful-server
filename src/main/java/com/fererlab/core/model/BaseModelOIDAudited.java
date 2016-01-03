package com.fererlab.core.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@MappedSuperclass
public abstract class BaseModelOIDAudited extends AuditModel<String> {

    private static final long serialVersionUID = 8196922538061529723L;

    private String id = null;

    public BaseModelOIDAudited(String id) {
        this.id = id;
    }

    protected BaseModelOIDAudited() {
    }

    @Id
    @Column(name = "BMOA_OID", updatable = false, nullable = false)
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
