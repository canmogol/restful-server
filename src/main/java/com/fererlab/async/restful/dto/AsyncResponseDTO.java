package com.fererlab.async.restful.dto;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class AsyncResponseDTO implements Serializable {

    private static final long serialVersionUID = -2526678660828529152L;

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
