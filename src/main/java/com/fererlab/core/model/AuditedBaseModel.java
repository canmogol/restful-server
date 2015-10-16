package com.fererlab.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
@MappedSuperclass
public abstract class AuditedBaseModel<T> extends AuditModel implements BaseModel<T> {

    private static final long serialVersionUID = 6137854137766230777L;

    private Long version = 0L;

    @Version
    @Column(name = "ABM_VERSION", nullable = false)
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditedBaseModel<?> baseAuditedBaseModel = (AuditedBaseModel<?>) o;
        return Objects.equals(getId(), baseAuditedBaseModel.getId()) &&
                Objects.equals(getVersion(), baseAuditedBaseModel.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion());
    }

}
