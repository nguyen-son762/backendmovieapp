package com.java.movieapp.controllers;

import com.java.movieapp.entity.AuthRequest;
import com.java.movieapp.entity.UserEntity;
import com.java.movieapp.entity.UserRequest;
import com.java.movieapp.service.UserService;
import com.java.movieapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
     @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody UserEntity userEntity){
         java.util.Date date=new java.util.Date();
         Map<String,Object> map=new HashMap<>();
         userEntity.setCreateAt(date);
         userEntity.setUpdateAt(date);
        List<UserEntity> userEntity1=userService.findByEmail(userEntity.getEmail());
        if(userEntity1.isEmpty()){
            userService.save(userEntity);
            String token=jwtUtil.generateToken(userEntity.getEmail());
            map.put("user",userEntity);
            map.put("token", token);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
        return new ResponseEntity<Object>( null, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/user/login")
    public ResponseEntity<Object>  findUser(@RequestBody UserRequest payload){
        Map<String,Object> map=new HashMap<>();
        List<UserEntity> userEntity=userService.findByEmail(payload.getEmail());
        if (userEntity.isEmpty()){
            return new ResponseEntity<Object>( null, HttpStatus.NOT_FOUND);
        }
        else {
            for (UserEntity userEntity1:userEntity){
                if(userEntity1.getPassword().equals(payload.getPassword())) {
                    String token=jwtUtil.generateToken(payload.getEmail());
                    map.put("user",userEntity1);
                    map.put("token", token);
                    return new ResponseEntity<Object>(map, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<Object>( null, HttpStatus.NOT_FOUND);
    }
}
