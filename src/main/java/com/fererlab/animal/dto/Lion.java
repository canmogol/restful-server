package com.fererlab.animal.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lion extends Animal {

    private Double weight;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}