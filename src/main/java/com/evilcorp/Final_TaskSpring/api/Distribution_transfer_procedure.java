package com.evilcorp.Final_TaskSpring.api;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Distribution_transfer_procedure { // Класс "Процедура передачи дистрибутива"
    private enum Status {
        Created, // Создана процедура передачи дистрибутива (Загружена готовая сборка дистрибутива и подготовлена для передачи)
        Changes_are_being_made, // Внесение изменений в процедуру передачи дистрибутива
        Procedure_is_over // Процедура передачи дистрибутива окончена
    }
    private UUID procedure_id; // Идентификатор процедуры
    private UUID creator_id; // Идентификатор пользователя, создавшего процедуру передачи дистрибутива
    private Implementation_object implementation_object; // Объект внедрения, передаваемый по этой процедуре
    private UUID distribution_builder; // Идентификатор специалист, осуществляющего передачу указанного дистрибутива для установки на объекте внедрения
    private UUID serviceman; // Идентификатор специалист, получивший дистрибутив для установки ПО на объекте внедрения
    private Date change_time;  // Дата и время внесения последнего изменения в процедуре
    private Status status; //
    private String comments; // Комментарии


}
