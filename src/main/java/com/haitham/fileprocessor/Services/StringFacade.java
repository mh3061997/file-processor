package com.haitham.fileprocessor.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class StringFacade {

    private final StorageService storageService;

    @Autowired
    public StringFacade(StorageService storageService) {
        this.storageService = storageService;
    }

    public Path getRandomFile() {
        List<Path> paths = storageService.getAllFilePaths();
        int numFile = new Random().nextInt(paths.size());
        return paths.get(numFile);
    }

    public String getRandomLine() throws IOException {
        Path filePath = getRandomFile();
        List<String> lines = Files.readAllLines(filePath);
        int lineNumber = new Random().nextInt(lines.size());
        return lines.get(lineNumber);
    }

    public String getRandomLineBackward() throws IOException {
        String line = getRandomLine();
        return new StringBuilder().append(line).reverse().toString();
    }


    public List<String> getLongestNLines(int numLines, List<Path> paths) {
        TreeSet<String> lines = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() < o2.length() ? 1 : -1;
            }
        });

        paths.forEach(path -> {
            try {
                lines.addAll(Files.readAllLines(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        List<String> linesList = lines.stream().toList();
        return linesList.subList(0, Math.min(linesList.size(), numLines));
    }

    public List<String> getLongestHunderdLines() {
        List<Path> paths = storageService.getAllFilePaths();
        return getLongestNLines(100, paths);
    }

    public List<String> getLongestTwentyLines(boolean useLatestFile) {
        List<Path> paths = new ArrayList<>();
        if(useLatestFile){
            paths.add(storageService.getAllFilePaths().get(0));
        }else{
            paths.add(getRandomFile());
        }
        return getLongestNLines(20, paths);
    }
}
