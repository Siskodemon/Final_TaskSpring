package com.evilcorp.Final_TaskSpring.api;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String soname;
    private String lastname;
    private String firstname;

}
