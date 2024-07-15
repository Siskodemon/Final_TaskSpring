package com.evilcorp.Final_TaskSpring.filework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    // Загрузка файла
    @PostMapping("/upload")
    public ResponseEntity<FileEntity> uploadFile(@RequestBody FileEntity file) {
        FileEntity savedFile = fileService.saveFile((MultipartFile) file);
        return ResponseEntity.ok(savedFile);
    }

    // Скачивание файла по его идентификатору
    @GetMapping("/download/{id}")
    public ResponseEntity<UrlResource> downloadFile(@PathVariable Long id) {
        // Получаем файл по идентификатору
        FileEntity file = fileService.getFileById(id);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }

        // Загружаем файл с сервера
        Path filePath = Paths.get(file.getFilePath());
        UrlResource resource;
        try {
            resource = new UrlResource(filePath.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                throw new RuntimeException("Файл не найден или не может быть прочитан");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Ошибка при загрузке файла", e);
        }

        // Возвращаем файл в ответе
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }

    // Фильтрация файлов по критериям
    @GetMapping("/filter")
    public ResponseEntity<List<FileEntity>> filterFiles(@RequestParam(required = false) LocalDate uploadDate,
                                                        @RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String version,
                                                        @RequestParam(required = false) String creatorFullName) {
        List<FileEntity> files = fileService.getFilesByCriteria(uploadDate, name, version, creatorFullName);
        return ResponseEntity.ok(files);
    }
}
