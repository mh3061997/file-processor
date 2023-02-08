package com.haitham.fileprocessor.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface StorageService {

    void init() throws Exception;
    void store(MultipartFile file) throws IOException;

    List<Path> getAllFilePaths();
}
