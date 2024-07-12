package com.evilcorp.Final_TaskSpring.api;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class User { // Класс пользователя
    private UUID id;
    private String lastname; // Фамилия пользователя
    private String firstname; // Имя пользователя
    private String soname; // Отчество пользователя
    private Date create_date;

    public User(String lastname, String firstname,String soname){
        this.lastname = lastname;
        this.firstname = firstname;
        this.soname = soname;
        this.create_date = new Date();
        this.id = UUID.randomUUID();
    }

}
