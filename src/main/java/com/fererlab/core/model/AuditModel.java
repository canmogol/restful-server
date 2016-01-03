package com.fererlab.core.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@MappedSuperclass
@EntityListeners({AuditModelListener.class})
//Please Refer to "JSR-000338 JavaTM Persistence 2.1 Final Release" document's "3.5.1 Entity Listeners"
public abstract class AuditModel<T> extends BaseModel<T> {

    private static final long serialVersionUID = 1419022173740235697L;

    private String createdBy;
    private Date creationDate;
    private String updatedBy;
    private Date updateDate;
    private String deletedBy;
    private Date deleteDate;

    @Column(name = "AUM_CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUM_CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "AUM_UPDATED_BY")
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUM_UPDATE_DATE")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name = "AUM_DELETED_BY")
    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AUM_DELETED_DATE")
    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

}
