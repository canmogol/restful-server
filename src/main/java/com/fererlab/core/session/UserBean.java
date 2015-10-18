package com.fererlab.core.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class UserBean {

    @Inject
    private SessionData sessionData;

    public String getUserName() {
        return sessionData.getUsername();
    }

}
