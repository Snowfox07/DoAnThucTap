package com.example.doanthuctap.repository;

import com.example.doanthuctap.dto.UserDTO;
import com.example.doanthuctap.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findOneByEmail(String email);
}
