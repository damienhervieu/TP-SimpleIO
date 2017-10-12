import java.io.IOException;

public class FileManager {
    public static void main(String[] args) throws IOException {
        String commandPath = "Spécifiez le chemin du dossier que vous voulez scanner : ";
        DocumentWriter txt = new DocumentWriter();
        String path = txt.getScanner(commandPath);
        txt.testPath(path);
    }
}
