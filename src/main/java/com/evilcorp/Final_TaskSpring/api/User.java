package com.evilcorp.Final_TaskSpring.api;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data // Анатация говорит нам что создание конструкторов, "геттеров и сетторов" не требуеться (зависимость Lombok)
public class User { // Класс пользователя


    private UUID id;
    private String lastname; // Фамилия пользователя
    private String firstname; // Имя пользователя
    private String soname; // Отчество пользователя
    private Date create_date;
    private String role; // роль

    public User(String lastname, String firstname,String soname, String role){
        this.lastname = lastname;
        this.firstname = firstname;
        this.soname = soname;
        this.create_date = new Date();
        this.id = UUID.randomUUID();
        this.role = role;
    }

}
