package com.ynov.io;

public class SearchFilesByExtension {
    public static void main(String[] args) {
        String commandPath = "Spécifiez le chemin du dossier que vous voulez scanner : ";
        String commandExtension = "Quel type d'extension voulez vous chercher ?(.py, .pdf, .docx) : ";
        FileReading fileReading = new FileReading();
        String path = fileReading.readScanner(commandPath);
        String extension = fileReading.readScanner(commandExtension);
        fileReading.searchFiles(path, extension);
    }
}
