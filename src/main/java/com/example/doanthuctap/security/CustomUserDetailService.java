package com.example.doanthuctap.security;

import com.example.doanthuctap.entity.UserEntity;
import com.example.doanthuctap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserEntityByEmail(username).get();
        if(user==null){
            throw new UsernameNotFoundException("User Not found");
        }else {
            if(user.isDelete()==true){
                throw new UsernameNotFoundException("User Not found");
            }
            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
            list.add(authority);
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassWord(), list);
            return userDetails;
        }
    }
}
