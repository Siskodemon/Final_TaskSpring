package com.evilcorp.Final_TaskSpring.api;

import java.util.Date;
import java.util.UUID;

public class Distribution_builder {

    private User user;
    private UUID id;
    private String job_title;

    public Distribution_builder(String job_title, String firstname,String lastname,String soname) {
        user.setId(UUID.randomUUID());
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setSoname(soname);
        user.setCreate_date(new Date());

        this.id = user.getId();
        this.job_title = job_title;
    }
}
