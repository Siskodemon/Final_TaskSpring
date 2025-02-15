package com.evilcorp.Final_TaskSpring.api.controller;

import com.evilcorp.Final_TaskSpring.api.User;
import com.evilcorp.Final_TaskSpring.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController { //Класс для обозначения тьочек входа для взаимодействия с нешей системой
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
        public List<User> getAllUsers(){
            return userRepository.findAll();
        }



}
