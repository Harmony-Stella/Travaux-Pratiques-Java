package Threads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

public class Fichiers implements Runnable {

    private String inDirPath = "C:\\Users\\Harmony Bunny\\Documents\\LICENCE3-GL\\SEMESTRE 5\\Systeme reparatis\\TPS\\IN";
    private String outDirPath = "C:\\Users\\Harmony Bunny\\Documents\\LICENCE3-GL\\SEMESTRE 5\\Systeme reparatis\\TPS\\OUT";
    private String fileExtension;
    private long timeout;

    public Fichiers(String inDirPath, String outDirPath, String fileExtension, long timeout) {
        this.inDirPath = inDirPath;
        this.outDirPath = outDirPath;
        this.fileExtension = fileExtension;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            // Attendre un peu avant de commencer pour laisser le temps au programme de se lancer complètement
            Thread.sleep(1000);

            // Définir les chemins des dossiers IN et OUT
            Path inDir = new File(inDirPath).toPath();
            Path outDir = new File(outDirPath).toPath();

            // Tant que le temps n'est pas écoulé, scanner le dossier IN pour les fichiers avec l'extension .txt
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < timeout) {
                Files.list(inDir)
                        .filter(path -> path.toString().endsWith(fileExtension))
                        .forEach(path -> {
                            try {
                                // Copier le fichier dans le dossier OUT en y ajoutant l'extension .back
                                Path newFilePath = outDir.resolve(path.getFileName().toString() + ".back");
                                Files.copy(path, newFilePath, StandardCopyOption.REPLACE_EXISTING);
                                // Supprimer le fichier du dossier IN
                                Files.delete(path);
                            } catch (IOException e) {
                                System.err.println("Erreur lors de la copie du fichier : " + e.getMessage());
                            }
                        });
                // Attendre un peu avant de scanner à nouveau
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Le thread a été interrompu : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des fichiers : " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String inDirPath = "C:\\Users\\Harmony Bunny\\Documents\\LICENCE3-GL\\SEMESTRE 5\\Systeme reparatis\\TPS\\IN";
        String outDirPath = "C:\\Users\\Harmony Bunny\\Documents\\LICENCE3-GL\\SEMESTRE 5\\Systeme reparatis\\TPS\\OUT";
        String fileExtension = ".txt";
        long timeout = TimeUnit.MINUTES.toMillis(1);
        Fichiers folderScanner = new Fichiers(inDirPath, outDirPath, fileExtension, timeout);
        Thread thread = new Thread(folderScanner);
        thread.start();
    }
}

