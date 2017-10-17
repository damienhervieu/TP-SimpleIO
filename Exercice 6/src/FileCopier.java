import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class FileCopier {

    private Scanner reader;

    public FileCopier () {
        reader = new Scanner(System.in);
    }

    public String getScanner (String command) {
        System.out.print(command);
        return reader.nextLine();
    }

    public void testPath (String path) throws IOException {
        File pathChecking = new File(path);
        if (pathChecking.isFile()) {
            System.out.println("Le chemin d'accès que vous avez donné existe et c'est un fichier");
        } else if (pathChecking.isDirectory()) {
            System.out.println("Le chemin d'accès que vous avez donné existe");
            String commandFileName = "Spécifiez le nom du fichier que vous voulez copier avec son extension : ";
            path = path + File.separator + getScanner(commandFileName);
        } else {
            System.out.println("Le chemin spécifié n'existe pas ou a été mal tapé");
        }
    }

    public void copyFile(String pathOriginal, String pathDestination) throws IOException {
        try {
            File inputFile = new File(pathOriginal);
            File outputFile = new File(pathDestination);

            FileChannel input = new FileInputStream(inputFile).getChannel();
            FileChannel output = new FileOutputStream(outputFile, true).getChannel();

            output.position(output.size());
            input.transferTo(0, input.size(), input);

            input.close();
            output.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
