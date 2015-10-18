package com.fererlab.user.service;

import com.fererlab.user.model.User;
import com.fererlab.user.serviceengine.dto.UserDTO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless(name = "UserCopyStrategy", mappedName = "UserCopyStrategy")
@LocalBean
public class UserCopyStrategy {

    public void copy(User entity, UserDTO dto) {
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
    }

    public void copy(UserDTO dto, User entity) {
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
    }
}
