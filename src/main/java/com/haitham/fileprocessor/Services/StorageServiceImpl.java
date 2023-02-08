package com.haitham.fileprocessor.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService {

    public final Path path = Paths.get("files");

    StorageServiceImpl() throws Exception {
        this.init();
    }

    @Override
    public void init() throws Exception {
        try {
            Files.createDirectories(path);
        } catch (Exception e) {
            throw new Exception("Could not create folder !");
        }
    }

    @Override
    public void store(MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), this.path.resolve(file.getOriginalFilename()));
    }

    @Override
    public List<Path> getAllFilePaths() {
        try {
            return Files.walk(this.path, 1)
                    .filter(path -> !path.equals(this.path))
                    .sorted((o1, o2) -> {return o1.toFile().lastModified() < o2.toFile().lastModified() ? 1:-1;})
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
