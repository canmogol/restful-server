package com.fererlab.user.service;

import com.fererlab.core.exception.ErrorCode;
import com.fererlab.core.exception.ServiceException;
import com.fererlab.user.model.User;
import com.fererlab.user.serviceengine.UserServiceEngine;
import com.fererlab.user.serviceengine.dto.UserDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "UserServiceEngineImpl", mappedName = "UserServiceEngineImpl")
public class UserServiceEngineImpl implements UserServiceEngine {

    @EJB(name = "UserCopyStrategy")
    private UserCopyStrategy userCopyStrategy;

    @EJB(name = "UserServiceImpl")
    private UserService userService;

    @Override
    public UserDTO find(Integer id) throws ServiceException {
        // find user by id
        User user = userService.findById(id);
        // create and return a response dto
        UserDTO userDTO = new UserDTO();
        userCopyStrategy.copy(
                user,
                userDTO
        );
        return userDTO;
    }

    @Override
    public UserDTO create(UserDTO dto) throws ServiceException {
        throw new ServiceException("could not create user", ErrorCode.DB);
//        // create a user at db
//        User user = userService.create(dto.getUsername(), dto.getPassword());
//        // create and return a response dto
//        UserDTO userDTO = new UserDTO();
//        userCopyStrategy.copy(
//                user,
//                userDTO
//        );
//        return userDTO;
    }

    @Override
    public UserDTO update(UserDTO dto) throws ServiceException {
        // find user by id
        User user = userService.findById(dto.getId());
        // copy new user info to entity
        userCopyStrategy.copy(
                dto,
                user
        );
        // update user entity
        userService.update(user);
        // create and return a response dto
        UserDTO userDTO = new UserDTO();
        userCopyStrategy.copy(
                user,
                userDTO
        );
        return userDTO;
    }

    @Override
    public UserDTO delete(Integer id) throws ServiceException {
        // find user by id
        User user = userService.findById(id);
        // delete user entity
        userService.delete(id);
        // create and return a response dto
        UserDTO userDTO = new UserDTO();
        userCopyStrategy.copy(
                user,
                userDTO
        );
        return userDTO;
    }

}
