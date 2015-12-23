package com.fererlab.user.serviceengine;


import com.fererlab.core.exception.ServiceException;
import com.fererlab.user.serviceengine.dto.UserDTO;

import javax.ejb.Local;

@Local
public interface UserServiceEngine {

    UserDTO find(Integer id) throws ServiceException;

    UserDTO create(UserDTO dto) throws ServiceException;

    UserDTO update(UserDTO dto) throws ServiceException;

    UserDTO delete(Integer id) throws ServiceException;

}
