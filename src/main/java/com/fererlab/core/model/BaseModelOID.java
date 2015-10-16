package com.fererlab.core.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@MappedSuperclass
public abstract class BaseModelOID implements BaseModel<String> {

    private static final long serialVersionUID = -8972332672554682948L;

    private String id = null;

    private Long version = 0L;

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

    @Version
    @Column(name = "BMOID_VERSION", nullable = false)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
