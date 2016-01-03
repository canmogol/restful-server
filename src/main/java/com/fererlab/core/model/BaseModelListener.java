package com.fererlab.core.model;

import javax.persistence.PreRemove;

public class BaseModelListener {

    @PreRemove
    public void auditDelete(BaseModel baseModel) {
        throw new IllegalStateException("Cannot delete/remove BaseModel, use DAO method delete instead, model: " + baseModel.getClass().getName() + " id: " + baseModel.getId());
    }

}