package com.fererlab.city.model;

public interface City<T> {

    T getId();

    void setId(T t);

    String getName();

    void setName(String name);

}
