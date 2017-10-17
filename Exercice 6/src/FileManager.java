import java.io.IOException;

public class FileManager{
    public static void main(String[] args) throws IOException{
        String commandPathOriginal = "Spécifiez le chemin du fichier que vous voulez copier : ";
        String commandPathDestination = "Spécifiez le chemin où vous voulez copier le fichier : ";
        FileCopier file = new FileCopier();
        String pathOriginal = file.getScanner(commandPathOriginal);
        file.testPath(pathOriginal);
        String pathDestination = file.getScanner(commandPathDestination);
        file.testPath(pathDestination);
        file.copyFile(pathOriginal, pathDestination);
    }
}
