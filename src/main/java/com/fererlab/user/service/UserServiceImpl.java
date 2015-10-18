package com.fererlab.user.service;

import com.fererlab.core.dao.BaseDAO;
import com.fererlab.core.service.AbstractService;
import com.fererlab.user.dao.UserDAO;
import com.fererlab.user.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "UserServiceImpl", mappedName = "UserServiceImpl")
public class UserServiceImpl extends AbstractService<User, Integer> implements UserService {

    @EJB(beanName = "UserDAOImpl")
    private UserDAO userDAO;

    @Override
    public BaseDAO<User, Integer> getBaseDAO() {
        return userDAO;
    }

    @Override
    public User create(String username, String password) {
        // create new user object and set params
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        // persist user object
        create(user);
        // return persisted object, this should have an ID
        return user;
    }
}
