package com.fererlab.generic.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public interface BaseDTO<PK> extends Serializable {

    PK getId();

    void setId(PK pk);

}
