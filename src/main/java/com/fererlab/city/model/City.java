package com.fererlab.city.model;

import com.fererlab.core.model.BaseModel;

public interface City<T> extends BaseModel<T> {

    String getName();

    void setName(String name);

}
