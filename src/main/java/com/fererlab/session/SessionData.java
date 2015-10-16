package com.fererlab.session;

import java.io.Serializable;
import java.util.Random;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SessionData implements Serializable {

    private static final long serialVersionUID = 9052283325560228523L;

    private String username;

    public String getUsername() {
        if (username == null) {
            username = "Guest-" + new Random().nextDouble();
        }
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}