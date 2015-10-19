package com.fererlab.car.dto;


import com.fererlab.generic.dto.BaseDTO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarDTO implements BaseDTO<Integer> {

    private static final long serialVersionUID = -740483451347807975L;

    private Integer id;
    private Integer model;
    private String manufacturer;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
