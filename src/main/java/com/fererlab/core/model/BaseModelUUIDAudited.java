package com.fererlab.core.model;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
@MappedSuperclass
public abstract class BaseModelUUIDAudited extends AuditedBaseModel<String> {

    private static final long serialVersionUID = -4417999190646680872L;

    private String id = generate();

    @Id
    @Column(name = "UABM_UUID", updatable = false, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
