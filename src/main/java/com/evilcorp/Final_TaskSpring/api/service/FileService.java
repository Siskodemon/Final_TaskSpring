package com.evilcorp.Final_TaskSpring.api.service;

import com.evilcorp.Final_TaskSpring.api.FileEntity;
import com.evilcorp.Final_TaskSpring.api.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class FileService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(FileService.class);
    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private FileRepository fileRepository;

    public FileEntity saveFile(MultipartFile file) {
        // Создаем директорию для загрузки файлов, если она не существует
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                logger.info("Ошибка при создании директории для загрузки файлов");
                throw new RuntimeException("Ошибка при создании директории для загрузки файлов", e);
            }
        }

        // Сохраняем файл на диск
        try {
            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath);

            // Создаем сущность файла и сохраняем ее в базе данных
            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setFilePath(filePath.toString());
            fileEntity.setUploadDate(LocalDate.now());

            logger.info("Файл успешно сохранен");
            return fileRepository.save(fileEntity);
        } catch (IOException e) {
            logger.info("Ошибка при сохранении файла");
            throw new RuntimeException("Ошибка при сохранении файла", e);
        }
    }
    // Получение файла по идентификатору
    public FileEntity getFileById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    // Получение файлов по критериям фильтрации
    public List<FileEntity> getFilesByCriteria(LocalDate uploadDate, String name, String version, String creatorFullName) {
        List<FileEntity> result = new ArrayList<>();
        if (uploadDate != null) result.addAll(fileRepository.findByUploadDate(uploadDate));
        if (name != null && !name.isEmpty()) result.addAll(fileRepository.findByName(name));
        if (version != null && !version.isEmpty()) result.addAll(fileRepository.findByVersion(version));
        if (creatorFullName != null && !creatorFullName.isEmpty()) result.addAll(fileRepository.findByCreatorFullName(creatorFullName));
        return result;
    }
}
