package com.example.doanthuctap.service.implement;

import com.example.doanthuctap.entity.CustomUserDetail;
import com.example.doanthuctap.entity.UserEntity;
import com.example.doanthuctap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findUserEntityByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("User not found"));

        return user.map(CustomUserDetail::new).get();
    }
}
