package com.haitham.fileprocessor.controllers;

import com.haitham.fileprocessor.Services.StorageService;
import com.haitham.fileprocessor.Services.StringFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.Random;

@RequestMapping(value = "file")
@RestController
public class FileController {

    private final StorageService storage;
    private final StringFacade stringFacade;

    @Autowired
    public FileController(StorageService storage, StringFacade stringFacade) {
        this.storage = storage;
        this.stringFacade = stringFacade;
    }

    @PostMapping(value = "upload")
    ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            storage.store(file);
            return new ResponseEntity<>("File uploaded successfully", HttpStatus.CREATED);
        } catch (FileAlreadyExistsException e) {
            return new ResponseEntity<>("File already exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "random-line")
    ResponseEntity<String> randomLine() throws IOException {
        return ResponseEntity.ok(stringFacade.getRandomLine());
    }

    @GetMapping(value = "backward-random-line")
    ResponseEntity<String> backwardRandomLine() throws IOException {
        return ResponseEntity.ok(stringFacade.getRandomLineBackward());
    }

    @GetMapping(value = "longest-100-lines")
    ResponseEntity<List<String>> longestHundredLines() {
        return ResponseEntity.ok(stringFacade.getLongestHunderdLines());
    }

    @GetMapping(value = "20-lines")
    ResponseEntity<List<String>> twentyLines() {
        return null;
    }
}
