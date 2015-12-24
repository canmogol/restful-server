package com.fererlab.user.serviceengine;


import com.fererlab.user.exception.UserDatabaseException;
import com.fererlab.user.exception.UserException;
import com.fererlab.user.exception.UserIOException;
import com.fererlab.user.serviceengine.dto.UserDTO;

import javax.ejb.Local;

@Local
public interface UserServiceEngine {

    UserDTO throwNullPointerException(Integer id);

    UserDTO throwUserException(Integer id) throws UserException;

    UserDTO throwUserDatabaseException(Integer id) throws UserDatabaseException;

    UserDTO throwUserIOException(Integer id) throws UserIOException;

    UserDTO find(Integer id);

    UserDTO create(UserDTO dto);

    UserDTO update(UserDTO dto);

    UserDTO delete(Integer id);

}
