package com.evilcorp.Final_TaskSpring.api;

import java.util.Date;
import java.util.UUID;

public class Distribution_builder { // Класс описывающий специалиста, подготовившего сборку дистрибутива для передачи "Сервисмену" с целью установки ПО на станции

    private User user;
    private UUID id; // Уникальный ID сборщика дистрибутива
    private String job_title; // поле "Должность"

    //конструктор для создания объекта "Сборщик дистрибутива"
    public Distribution_builder(String job_title, String firstname,String lastname,String soname) {
        user.setId(UUID.randomUUID()); // Генерируем уникальный ID
        user.setFirstname(firstname); // Присваевааем переданое имя новому "Сборщику"
        user.setLastname(lastname); // Присваевааем переданую фамилию новому "Сборщику"
        user.setSoname(soname); // Присваевааем переданое отчество новому "Сборщику"
        user.setCreate_date(new Date()); // Фиксируем дату и время создания нового объекта

        this.id = user.getId(); // Присваемваем идентификатору Сборщика идентификатор Пользователя
        this.job_title = job_title; // Присваевааем переданую должность новому "Сборщику"
    }
}
