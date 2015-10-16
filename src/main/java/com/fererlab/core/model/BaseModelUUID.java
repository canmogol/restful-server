package com.fererlab.core.model;


import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseModelUUID implements BaseModel<String> {

    private static final long serialVersionUID = 4099800439835588676L;

    private String id = generate();

    private Long version = 0L;

    @Id
    @Column(name = "BMUUID_UUID", updatable = false, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Version
    @Column(name = "BMUUID_VERSION", nullable = false)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private String generate() {
        try {
            EthernetAddress ethernetAddress = EthernetAddress.fromInterface();
            TimeBasedGenerator uuidGenerator = Generators.timeBasedGenerator(ethernetAddress);
            UUID uuid = uuidGenerator.generate();
            return uuid.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return UUID.randomUUID().toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseModelUUID model = (BaseModelUUID) o;
        return Objects.equals(getId(), model.getId()) &&
                Objects.equals(getVersion(), model.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion());
    }


}
