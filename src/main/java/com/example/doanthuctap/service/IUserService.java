package com.example.doanthuctap.service;

import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.UserEntity;

import java.util.List;

public interface IUserService {
    UserEntity saveUser(UserDTO userDTO);
    UserEntity getUser(String email);
    List<UserDTO> getUser();
}
