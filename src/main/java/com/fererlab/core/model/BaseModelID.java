package com.fererlab.core.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlRootElement
@MappedSuperclass
public abstract class BaseModelID<T extends Number> extends BaseModel<T> {

    private static final long serialVersionUID = -8972284080373473337L;

    private T t;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BM_SEQ")
    @SequenceGenerator(name = "BM_SEQ", sequenceName = "BM_SEQ", allocationSize = 1)
    @Column(name = "BM_ID", updatable = false, nullable = false)
    @XmlElement(type = Number.class)
    @XmlSchemaType(name = "long"/*this will be the type of the id at the generated client side*/)
    public T getId() {
        return t;
    }

    public void setId(T t) {
        this.t = t;
    }

}
