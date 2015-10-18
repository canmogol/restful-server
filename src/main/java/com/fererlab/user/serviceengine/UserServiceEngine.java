package com.fererlab.user.serviceengine;


import com.fererlab.user.serviceengine.dto.UserDTO;

import javax.ejb.Local;

@Local
public interface UserServiceEngine {

    UserDTO find(Integer id);

    UserDTO create(UserDTO dto);

    UserDTO update(UserDTO dto);

    UserDTO delete(Integer id);

}
