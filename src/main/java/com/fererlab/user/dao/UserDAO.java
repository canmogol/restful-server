package com.fererlab.user.dao;


import com.fererlab.core.dao.BaseDAO;
import com.fererlab.user.model.User;

import javax.ejb.Local;


@Local
public interface UserDAO extends BaseDAO<User, Integer> {

}
