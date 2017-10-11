import java.io.File;
import java.util.Scanner;

public class TreatPath {
    private Scanner reader;

    public TreatPath() {
        reader = new Scanner(System.in);
    }

    public String getPath() {
        System.out.print("Spécifiez le chemin du dossier que vous voulez scanner : ");
        return reader.nextLine();
    }

    public void verifyPath(String path){
        File pathChecking = new File(path);
        if (pathChecking.isFile()) {
            System.out.println("Le chemin d'accès que vous avez donné existe et c'est un fichier");
        } else if (pathChecking.isDirectory()) {
            System.out.println("Le chemin d'accès que vous avez donné existe et c'est un dossier");
        } else {
            System.out.println("Le chemin spécifié n'existe pas ou a été mal tapé");
        }
    }
}
