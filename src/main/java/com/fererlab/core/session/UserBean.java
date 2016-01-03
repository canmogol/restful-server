package com.fererlab.core.session;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable{

    private static final long serialVersionUID = 2966906380015710638L;

    @Inject
    private SessionData sessionData;

    public String getUserName() {
        return sessionData.getUsername();
    }

}
