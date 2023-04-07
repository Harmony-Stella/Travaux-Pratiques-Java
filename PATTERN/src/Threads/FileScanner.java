package Threads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileScanner implements Runnable {

    private String inDirPath;
    private String outDirPath;
    private String fileExtension;
    private long timeout;

    public FileScanner(String inDirPath, String outDirPath, String fileExtension, long timeout) {
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
            int filesCopied = 0;
            while (System.currentTimeMillis() - startTime < timeout) {
                filesCopied = Files.list(inDir)
                        .filter(path -> path.toString().endsWith(fileExtension))
                        .mapToInt(path -> {
                            try {
                                // Copier le fichier dans le dossier OUT en y ajoutant l'heure et la date de copie
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
                                String newFileName = sdf.format(new Date()) + "_" + path.getFileName().toString();
                                Path newFilePath = outDir.resolve(newFileName);
                                Files.copy(path, newFilePath, StandardCopyOption.REPLACE_EXISTING);
                                return 1;
                            } catch (IOException e) {
                                System.err.println("Erreur lors de la copie du fichier : " + e.getMessage());
                                return 0;
                            }
                        }).sum();
                // Attendre un peu avant de scanner à nouveau
                Thread.sleep(1000);
            }
            System.out.println("Nombre de fichiers copiés : " + filesCopied);
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
