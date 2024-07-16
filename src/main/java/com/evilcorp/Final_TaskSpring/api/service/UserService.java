package com.evilcorp.Final_TaskSpring.api.service;

import com.evilcorp.Final_TaskSpring.api.User;
import com.evilcorp.Final_TaskSpring.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired // Эта анатация вызывает объект класса как часть Spring Boot
    private UserRepository userRepository;


    public User createUser(String lastname, String firstname, String soname, String role){ // Создание нового пользователя
        return new User(lastname,firstname,soname,role);
    }



}
