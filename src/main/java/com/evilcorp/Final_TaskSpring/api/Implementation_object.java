package com.evilcorp.Final_TaskSpring.api;

import lombok.Data;
import java.util.Date;
import java.util.UUID;

//SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//Date date = new Date();
//		System.out.println(formater.format(date));

@Data // Анатация говорит нам что создание конструкторов, "геттеров и сетторов" не требуеться (зависимость Lombok)

public class Implementation_object { // Описание класса "Объект внедрения"
    private UUID id;
    private String name; // Наименование объекта внедрения
    private String railway; // Название железной дороги, ккоторой относиться создаваемый объект внедрения (если есть)
    private boolean non_public_paths; // Относиться ли объект внедрения к путям необщего пользования
    private Date create_date; // Дата создания объекта внедрнеия
    private String tpo_version; // Версия технологичекого программного обесечения
    private UUID creator_id; // Идентификатор пользователя, создавшего объект внедрения

    public Implementation_object(String name, String railway, String tpo_version, UUID creator_id   ) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.create_date = new Date();
        if (railway == null){
            non_public_paths = false;
            this.railway = railway;
        }else{
            non_public_paths = true;
            this.railway = null;
        }
        this.tpo_version = tpo_version;
        this.creator_id = creator_id;
    }
}
