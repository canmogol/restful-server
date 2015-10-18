package com.fererlab.user.model;

import com.fererlab.core.model.BaseModelID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "USER_ID_LONG")
public class User extends BaseModelID<Integer> {

    private static final long serialVersionUID = -2573763017488910282L;

    private String password;
    private String username;

    @Column(name = "USR_PASSWORD", length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "USR_USERNAME", length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
