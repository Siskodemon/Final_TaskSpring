package com.evilcorp.Final_TaskSpring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    @Autowired // Эта анатация вызывает объект класса как часть Spring Boot
    private UserRepository userRepository;


    public User createUser(String lastname, String firstname, String soname, String role){ // Создание нового пользователя
        return new User(lastname,firstname,soname,role);
    }



}
