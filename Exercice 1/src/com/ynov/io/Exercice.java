package com.ynov.io;

public class Exercice {
    public static void main(String[] args) {
        FileReading fileReading = new FileReading();
        String path = fileReading.readScanner();
        fileReading.searchFiles(path);
    }
}
