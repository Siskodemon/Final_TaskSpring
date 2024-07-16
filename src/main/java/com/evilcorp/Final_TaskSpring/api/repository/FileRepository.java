package com.evilcorp.Final_TaskSpring.api.repository;

import com.evilcorp.Final_TaskSpring.api.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    // Поиск файлов по дате загрузки
    List<FileEntity> findByUploadDate(LocalDate uploadDate);

    // Поиск файлов по названию
    List<FileEntity> findByName(String name);

    // Поиск файлов по версии
    List<FileEntity> findByVersion(String version);

    // Поиск файлов по ФИО Создателя дистрибутива
    List<FileEntity> findByCreatorFullName(String creatorFullName);
}