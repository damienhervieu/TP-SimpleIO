import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DocumentWriter {
    private Scanner reader;

    public DocumentWriter () {
        reader = new Scanner(System.in);
    }

    public String getScanner (String command) {
        System.out.print(command);
        return reader.nextLine();
    }

    public void testPath (String path) throws IOException {
        File pathChecking = new File(path);
        String startWrite = "Ecriture dans le fichier : " + pathChecking.getName() + " (entrez 'quit' pour arrêter d'écrire dans le fichier) : ";
        if (pathChecking.isFile()) {
            System.out.println("Le chemin d'accès que vous avez donné existe et c'est un fichier texte");
            System.out.println(startWrite);
            writeDocument(path);
        } else if (pathChecking.isDirectory()) {
            System.out.println("Le chemin d'accès que vous avez donné existe");
            String commandFileName = "Spécifiez le nom du fichier que vous voulez créer : ";
            path = path + File.separator + getScanner(commandFileName) + ".txt";
            System.out.println(startWrite);
            writeDocument(path);
        } else {
            System.out.println("Le chemin spécifié n'existe pas ou a été mal tapé");
        }
    }

    public void writeDocument(String path) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
            String line ="";
            while (!line.equals("quit")) {
                line = reader.nextLine();
                testLine(writer, line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String testLine(FileWriter writer, String line) throws IOException {
        if (line.equals("quit")){
            writer.close();
        } else {
            writer.write(line + System.getProperty("line.separator"));
        }
        return line;
    }
}
