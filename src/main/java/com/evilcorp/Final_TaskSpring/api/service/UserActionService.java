package com.evilcorp.Final_TaskSpring.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserActionService {
    private static final Logger logger = LoggerFactory.getLogger(UserActionService.class);

    // Метода, в котором логируются действия пользователя
    public void logUserAction(String username, String action) {
        logger.info("Пользователь: {}, Действие: {}", username, action);
    }

}
