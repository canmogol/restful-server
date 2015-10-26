package com.fererlab.animal.dto;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class GenericList {

    List list = new ArrayList<>();

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

}
