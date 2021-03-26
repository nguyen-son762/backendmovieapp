package com.java.movieapp.service;

import com.java.movieapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.naming.AuthenticationException;
import java.util.List;

public interface UserService {
    List<UserEntity> findByEmail(String email);
    UserEntity save(UserEntity userEntity);
    UserEntity findUserById(int id);
}
