package com.haitham.fileprocessor.models;

public class RandomLineDto {
    int lineNumber;
    String line;
    String fileName;
    Character mostFrequentLetter;

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Character getMostFrequentLetter() {
        return mostFrequentLetter;
    }

    public void setMostFrequentLetter(Character mostFrequentLetter) {
        this.mostFrequentLetter = mostFrequentLetter;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public RandomLineDto(int lineNumber, String line, String fileName, Character mostFrequentLetter) {
        this.lineNumber = lineNumber;
        this.line = line;
        this.fileName = fileName;
        this.mostFrequentLetter = mostFrequentLetter;
    }
}
