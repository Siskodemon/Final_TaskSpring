package com.evilcorp.Final_TaskSpring.api;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String lastname; // Фамилия пользователя
    private String firstname; // Имя пользователя
    private String soname; // Отчество пользователя
    private Date create_date;

}
