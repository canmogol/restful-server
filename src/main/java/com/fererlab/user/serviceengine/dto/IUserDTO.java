package com.fererlab.user.serviceengine.dto;

public interface IUserDTO<T> {

    T getId();

    void setId(T t);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

}
