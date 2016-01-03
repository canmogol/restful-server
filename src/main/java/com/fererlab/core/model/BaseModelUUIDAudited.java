package com.fererlab.core.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
@MappedSuperclass
public abstract class BaseModelUUIDAudited extends AuditModel<String> {

    private static final long serialVersionUID = -4417999190646680872L;

    private String id = UUID.randomUUID().toString();

    @Id
    @Column(name = "BMUA_UUID", updatable = false, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
