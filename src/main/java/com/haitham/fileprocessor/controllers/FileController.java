package com.haitham.fileprocessor.controllers;

import com.haitham.fileprocessor.Services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

@RequestMapping(value = "file")
@RestController
public class FileController {

    private final StorageService storage;

    @Autowired
    public FileController(StorageService storage) {
        this.storage = storage;
    }

    @PostMapping(value ="upload")
    ResponseEntity upload(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            storage.store(file);
            return new ResponseEntity<>("File uploaded successfully",HttpStatus.CREATED);
        }catch (FileAlreadyExistsException e){
            return new ResponseEntity<>("File already exists",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="random-line")
    void randomLine() {
    }

    @GetMapping(value="backward-random-line")
    void backwardRandomLine() {
    }

    @GetMapping(value="longest-100-lines")
    void longestHundredLines() {
    }

    @GetMapping(value="20-lines")
    void twentyLines() {
    }
}
