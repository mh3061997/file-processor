package com.haitham.fileprocessor.Services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

public interface StorageService {

    void init() throws Exception;
    void store(MultipartFile file) throws IOException;

    ArrayList<MultipartFile> getAllFiles();
}
