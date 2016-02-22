package com.fererlab.client.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthorizeDTO {

    private boolean authorized;
    private String uuid;

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
