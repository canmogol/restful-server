package com.fererlab.user.serviceengine.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class BaseUserDTO<T> implements IUserDTO<T> {

    private String username;
    private String password;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
