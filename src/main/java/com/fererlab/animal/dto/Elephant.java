package com.fererlab.animal.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Elephant extends Animal {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}