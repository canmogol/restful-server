package com.fererlab.core.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseModelUUID extends BaseModel<String> {

    private static final long serialVersionUID = 4099800439835588676L;

    private String id = UUID.randomUUID().toString();

    @Id
    @Column(name = "BMUUID_UUID", updatable = false, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
