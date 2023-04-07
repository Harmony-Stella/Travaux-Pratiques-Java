package TP3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Obtenir la date et l'heure actuelles
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        
        // Création d'un fichier de journal en format texte avec la date et l'heure dans le nom de fichier
        LogFile textLogFile = new TextLogFile("text_log_" + dateTime + ".txt");
        
        // Création d'un fichier de journal en format HTML avec la date et l'heure dans le nom de fichier
        LogFile htmlLogFile = new HTMLLogFile("html_log_" + dateTime + ".html");
        
        // Obtention des objets de formatage de journal pour chaque fichier de journal
        LogFormatter textLogFormatter = textLogFile.getFormatter();
        LogFormatter htmlLogFormatter = htmlLogFile.getFormatter();
        
        // Écriture d'informations de journal dans chaque fichier de journal à l'aide des objets de formatage
        textLogFormatter.logObject("Ceci est un test.");
        textLogFormatter.logCollection(Arrays.asList("Test", "Collection"));
        textLogFormatter.logMap(Collections.singletonMap("Test Key", "Test Value"));
        
        htmlLogFormatter.logObject("Ceci est un test.");
        htmlLogFormatter.logCollection(Arrays.asList("Test", "Collection"));
        htmlLogFormatter.logMap(Collections.singletonMap("Test Key", "Test Value"));
    }
}

