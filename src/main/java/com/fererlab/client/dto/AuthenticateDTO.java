package com.fererlab.client.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthenticateDTO {

    private boolean authenticated;
    private String uuid;

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
