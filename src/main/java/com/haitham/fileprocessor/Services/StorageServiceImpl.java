package com.haitham.fileprocessor.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {

    private final Path path = Paths.get("files");

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
    public ArrayList<MultipartFile> getAllFiles() {
        return null;
    }

    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.path, 1).filter(path -> !path.equals(this.path)).map(this.path::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
