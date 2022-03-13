package com.example.doanthuctap.service;

import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService{
    UserEntity save(UserDTO userDTO) throws Exception;
    List<UserDTO> listUser();
    UserDTO findByEmail(String email);
    UserDTO findById(int id);
    List<UserDTO> listUserAll();
    List<UserDTO> listUserAllIncludeDelete();
}
