package com.evilcorp.Final_TaskSpring.filework;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Уникальный идентификатор файла
    private String name; // Название файла
    private String version; // Версия файла
    private String creatorFullName; // ФИО Создателя дистрибутива
    private LocalDate uploadDate; // Дата загрузки файла
    private String filePath; // Путь к файлу на сервере

    // геттеры и сеттеры
}