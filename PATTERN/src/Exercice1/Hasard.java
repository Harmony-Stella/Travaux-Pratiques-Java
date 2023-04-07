package Exercice1;

import java.util.Random;

public class Hasard {
    private static Hasard instance = null;
    private Random random;

    private Hasard() {
        random = new Random();
    }

    public static Hasard getInstance() {
        if (instance == null) {
            instance = new Hasard();
        }
        return instance;
    }

    public <T> T hasard(T[] tableau) {
        int index = random.nextInt(tableau.length);
        return tableau[index];
    }

    public static void main(String[] args) {
        Hasard hasard = Hasard.getInstance();
        System.out.println("Buts marqués : " + hasard.hasard(new Integer[] { 0, 1, 2, 3, 4,5,6,7,8,9,10 }));
        System.out.println("Joueur : " + hasard.hasard(new String[] { "Fleurie", "Geraldo", "Valentin", "April" }));
        System.out.println("Possession de balle : " + hasard.hasard(new Double[] { 54.78, 45.22 ,10.34,25.78,34.06,67.89,70.05}));
    }
}

