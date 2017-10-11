package com.ynov.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReading {

    private Scanner reader;

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
            if (files[i].isFile()) {
                System.out.println("Fichier " + files[i].getName());
            } else if (files[i].isDirectory()) {
                System.out.println("Répertoire " + files[i].getName());
                searchFiles(files[i].getPath());
            }
        }
        return files;
    }
}
