package com.fererlab.core.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "OID_SEED")
@XmlRootElement
public class OIDSeed implements Model<String> {

    private static final long serialVersionUID = -4122856555701344411L;

    private String className;

    private Long sequenceCount;

    @Id
    @Column(name = "OID_ID", updatable = false, nullable = false)
    public String getId() {
        return className;
    }

    public void setId(String t) {
        this.className = t;
    }

    @Column(name = "OID_SEQ_COUNT")
    public Long getSequenceCount() {
        return sequenceCount;
    }

    public void setSequenceCount(Long sequenceCount) {
        this.sequenceCount = sequenceCount;
    }

}