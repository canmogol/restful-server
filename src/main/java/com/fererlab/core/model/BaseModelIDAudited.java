package com.fererlab.core.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlRootElement
@MappedSuperclass
public abstract class BaseModelIDAudited<T extends Number> extends AuditedBaseModel<T> {

    private static final long serialVersionUID = 8944877679279874598L;

    private T id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BIM_SEQ")
    @SequenceGenerator(name = "BIM_SEQ", sequenceName = "BIM_SEQ", allocationSize = 1)
    @Column(name = "IABM_ID", updatable = false, nullable = false)
    @XmlElement(type = Number.class)
    @XmlSchemaType(name = "long"/*this will be the type of the id at the generated client side*/)
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

}
