package com.example.doanthuctap.service.implement;

import com.example.doanthuctap.converter.UserConverter;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.UserEntity;
import com.example.doanthuctap.repository.UserRepository;
import com.example.doanthuctap.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService{
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserConverter userConverter;


    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserEntity save(UserDTO userDTO){
        String passEncode = this.passwordEncoder.encode(userDTO.getPassWord());
        userDTO.setPassWord(passEncode);
        return userRepository.save(userConverter.toEntity(userDTO));
    }

    @Override
    public List<UserDTO> listUser() {
        List<UserEntity> list = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity item: list) {
            if(item.isDelete()==false && item.getRole().equals("USER")){
                UserDTO dto = userConverter.toDTO(item);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    @Override
    public List<UserDTO> listUserAll() {
        List<UserEntity> list = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity item: list) {
            if(item.isDelete()==false){
                UserDTO dto = userConverter.toDTO(item);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    @Override
    public List<UserDTO> listUserAllIncludeDelete() {
        List<UserEntity> list = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        for (UserEntity item: list) {
            UserDTO dto = userConverter.toDTO(item);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userConverter.toDTO(userRepository.findOneByEmail(email));
    }

    @Override
    public UserDTO findById(int id) {
        return userConverter.toDTO(userRepository.findById(id).get());
    }


}
