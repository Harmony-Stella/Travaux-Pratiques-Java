package TP4;

import java.util.*;

public class Algorithme1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Entrez un montant en euros : ");
        int montant = sc.nextInt();

        int billet100 = montant / 100;
        montant %= 100;

        int billet50 = montant / 50;
        montant %= 50;

        int billet20 = montant / 20;
        montant %= 20;

        int billet10 = montant / 10;
        montant %= 10;

        int piece2 = montant / 2;
        montant %= 2;

        int piece1 = montant;

        String resultat = billet100 + " " + billet50 + " " + billet20 + " " + billet10 + " " + piece2 + " " + piece1;
        System.out.println(resultat);
	}
}
