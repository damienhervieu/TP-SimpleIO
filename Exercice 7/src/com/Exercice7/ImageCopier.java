package com.Exercice7;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ImageCopier {
    private Scanner reader;

    public ImageCopier () {
        reader = new Scanner(System.in);
    }

    public String getScanner (String command) {
        System.out.print(command);
        return reader.nextLine();
    }

    public void testPath (String path, String imageUrl) throws IOException {
        File pathChecking = new File(path);
        if (pathChecking.isDirectory()) {
            System.out.println("Le chemin d'accès que vous avez donné existe");
            String commandFileName = "Spécifiez le nom du fichier que vous voulez copier : ";
            path = path + File.separator + getScanner(commandFileName) + ".jpg";
            copyImage(imageUrl, path);
        } else {
            System.out.println("Le chemin spécifié n'existe pas ou a été mal tapé ou est un fichier");
        }
    }

    public void copyImage(String imageUrl, String path) throws IOException, MalformedURLException {
        URL url = new URL(imageUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(path);
        fos.write(response);
        fos.close();
    }
}
