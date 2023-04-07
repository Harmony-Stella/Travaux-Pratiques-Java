package Traducteur;

import java.util.*;

public class Francais {
    private static Set<String> motsFrancais = new HashSet<String>();

    public static void ajouterMot(String mot) {
        motsFrancais.add(mot);
    }

    public static boolean connaitMot(String mot) {
        return motsFrancais.contains(mot);
    }
    
    public static boolean isEmpty() {
        return motsFrancais.isEmpty();
    }

}
