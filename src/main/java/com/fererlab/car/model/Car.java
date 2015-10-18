package com.fererlab.car.model;

import com.fererlab.core.model.BaseModelID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "CAR_ID_INT")
public class Car extends BaseModelID<Integer> {

    private static final long serialVersionUID = -4249887673263058826L;

    private Integer model;
    private String manufacturer;

    @Column(name = "CAR_MODEL", length = 100)
    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    @Column(name = "CAR_MANUFCTRR", length = 100)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
