package com.fererlab.user.service;

import com.fererlab.core.service.BaseService;
import com.fererlab.user.model.User;

import javax.ejb.Local;

@Local
public interface UserService extends BaseService<User, Integer> {

    User create(String username, String password);

}
