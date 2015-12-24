package com.fererlab.user.service;

import com.fererlab.user.exception.UserDatabaseException;
import com.fererlab.user.exception.UserException;
import com.fererlab.user.exception.UserIOException;
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
    public UserDTO throwNullPointerException(Integer id) {
        UserDTO userDTO = null;
        userDTO.getPassword(); // will raise NullPointerException
        return userDTO;
    }

    @Override
    public UserDTO throwUserException(Integer id) throws UserException {
        throw new UserException("user with this id could not found");
    }

    @Override
    public UserDTO throwUserDatabaseException(Integer id) throws UserDatabaseException {
        throw new UserDatabaseException("Database could not query for this user");
    }

    @Override
    public UserDTO throwUserIOException(Integer id) throws UserIOException {
        throw new UserIOException("No user file found for this user");
    }

    @Override
    public UserDTO find(Integer id) {
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
    public UserDTO create(UserDTO dto) {
        // create a user at db
        User user = userService.create(dto.getUsername(), dto.getPassword());
        // create and return a response dto
        UserDTO userDTO = new UserDTO();
        userCopyStrategy.copy(
                user,
                userDTO
        );
        return userDTO;
    }

    @Override
    public UserDTO update(UserDTO dto) {
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
    public UserDTO delete(Integer id) {
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
