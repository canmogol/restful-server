package com.fererlab.async.restful.dto;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@XmlSeeAlso(AsyncResponseDTO.class)
@XmlRootElement
public class AsyncRequestDTO implements Serializable {

    private static final long serialVersionUID = -2526678660828529152L;

    private String request;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
