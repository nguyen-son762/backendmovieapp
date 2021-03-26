package com.java.movieapp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.movieapp.entity.FilmEntity;
import com.java.movieapp.entity.UserEntity;
import com.java.movieapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findUserById(int id) {
        Optional<UserEntity> optional =userRepository.findById(id);

        UserEntity userEntity = null;
        if (optional.isPresent()) {
            userEntity = optional.get();
        } else {
            throw new RuntimeException(" Film not found for id :: " + id);
        }
        return userEntity;
    }
}