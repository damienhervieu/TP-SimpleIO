package com.ynov.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class FileReading {


    private Scanner reader;
    private String[] extensions = new String[] {".py", ".php", ".txt"};

    public FileReading() {
        reader = new Scanner(System.in);
    }

    public String readScanner(String command) {
        System.out.print(command);
        return reader.nextLine();
    }

    static File[] searchFiles(String path, String extension) {
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && (files[i].getName().endsWith(extension))) {
                System.out.println("Fichier : " + files[i].getName());
            } else {
                System.out.println("Aucun fichier trouvé ou l'extension a été mal saisie");
            }
        }
        return files;
    }
}
