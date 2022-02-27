package com.example.doanthuctap.service.implement;

import com.example.doanthuctap.converter.UserConverter;
import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.UserEntity;
import com.example.doanthuctap.repository.UserRepository;
import com.example.doanthuctap.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserConverter converter;

    @Override
    public UserEntity saveUser(UserDTO userDTO) {
        return userRepository.save(converter.toEntity(userDTO));
    }

    @Override
    public UserEntity getUser(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public List<UserDTO> getUser() {
        return null;
    }
}
