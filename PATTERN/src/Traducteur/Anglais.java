package Traducteur;

import java.util.*;

public class Anglais {
    private static Map<String, String> traductions = new HashMap<String, String>();

    public static void ajouterTraduction(String mot, String traduction) {
        traductions.put(mot, traduction);
    }

    public static String traduire(String mot) {
        if (traductions.containsKey(mot)) {
            return traductions.get(mot);
        } else {
            return null;
        }
    }
}
