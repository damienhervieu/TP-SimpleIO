package com.Exercice7;

import java.io.IOException;

public class FileManager {
    public static void main(String[] args) throws IOException {
        ImageCopier image = new ImageCopier();
        String commandImageUrl = "Spécifiez l'url de votre image : ";
        String imageUrl = image.getScanner(commandImageUrl);
        String commandPath = "Spécifiez le chemin où vous voulez copier l'image : ";
        String path  = image.getScanner(commandPath);
        image.testPath(path, imageUrl);
    }
}
