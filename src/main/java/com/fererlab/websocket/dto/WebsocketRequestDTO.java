package com.fererlab.websocket.dto;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@XmlSeeAlso(WebsocketResponseDTO.class)
@XmlRootElement
public class WebsocketRequestDTO implements Serializable {

    private static final long serialVersionUID = -2526678660828529152L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
