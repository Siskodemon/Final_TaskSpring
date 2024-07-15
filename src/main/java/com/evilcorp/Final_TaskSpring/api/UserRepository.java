package com.evilcorp.Final_TaskSpring.api;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRepository {
    private final Map<UUID,User> users = new ConcurrentHashMap<>();

    public List<User> findAll(){ // Метод, возвращающий всех сохранённых пользователей
        return new ArrayList<>(users.values());
    }

    public User findById(UUID id){ // Метод, возвращающий пользователя по ID
        return users.get(id);
    }

    public  User save(User user){ // Метод, сохраняющий нового пользователя
        if (user.getId() == null){ // Если в переданом оюъекте пользователя ID не задано, то мы сначало его генерируем и только потом сохраняем
            user.setId(UUID.randomUUID());
        }
        users.put(user.getId(), user);
        return user;
    }
}
