package com.evilcorp.Final_TaskSpring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Настраивает цепочку фильтров безопасности.
     *
     * @param http объект HttpSecurity для настройки безопасности
     * @return настроенная цепочка фильтров безопасности
     * @throws Exception если возникает ошибка при настройке безопасности
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Настройка авторизации запросов
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/public/**").permitAll() // Разрешить доступ к публичным ресурсам
                                .anyRequest().authenticated() // Требовать аутентификацию для всех остальных запросов
                )
                // Настройка формы входа
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login") // Указать страницу входа
                                .permitAll() // Разрешить доступ к странице входа всем пользователям
                )
                // Настройка выхода из системы
                .logout(logout ->
                        logout
                                .permitAll() // Разрешить выход из системы всем пользователям
                );

        return http.build();
    }

    /**
     * Создает службу UserDetailsService для управления пользователями.
     *
     * @return объект UserDetailsService для управления пользователями
     */
    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();

        // Создание пользователя в памяти для тестирования
        var user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        userDetailsManager.createUser(user);

        return userDetailsManager;
    }
}
