package com.ynov.io;

import java.io.File;
import java.util.Scanner;
import java.lang.Object;

public class FileReading {


    private Scanner reader;
    private String[] extensions = new String[] {".py", ".php", ".txt"};

    public FileReading() {
        reader = new Scanner(System.in);
    }

    public String readScanner() {
        System.out.print("Spécifiez le chemin du dossier que vous voulez scanner :");
        return reader.nextLine();
    }

    static File[] searchFiles(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && files[i].FilenameUtils.getExtension()) {
                System.out.println("Fichier " + files[i].getName());
            } else if (files[i].isDirectory()) {
                System.out.println("Répertoire " + files[i].getName());
                searchFiles(files[i].getPath());
            }
        }
        return files;
}
