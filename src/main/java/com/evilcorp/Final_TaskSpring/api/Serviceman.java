package com.evilcorp.Final_TaskSpring.api;

import lombok.Data;
import net.minidev.json.JSONUtil;

@Data
public class Serviceman { // Класс описывающий "Сервисмен", описывающий людей, устанавливающих ПО на станции

    private User user;
    private String job_title;


}
