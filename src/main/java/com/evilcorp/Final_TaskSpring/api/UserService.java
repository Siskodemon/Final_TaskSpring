package com.evilcorp.Final_TaskSpring.api;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {


    public User createUser(String lastname,String firstname, String soname){ // Создание нового пользователя
        return new User(lastname,firstname,soname);
    }

/*    public User changeUser(User user){ // Создание нового пользователя

    }*/



}
