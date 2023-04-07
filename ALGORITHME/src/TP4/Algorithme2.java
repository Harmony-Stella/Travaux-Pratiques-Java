package TP4;

import java.util.*;

public class Algorithme2 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Entrez un montant en euros : ");
	        int montant = sc.nextInt();

	        int[] valeurs = {100, 50, 20, 10, 2, 1};
	        int[] quantites = new int[valeurs.length];

	        for (int i = 0; i < valeurs.length; i++) {
	            quantites[i] = montant / valeurs[i];
	            montant %= valeurs[i];
	        }

	        String resultat = "";
	        for (int i = 0; i < quantites.length; i++) {
	            resultat += quantites[i] + " ";
	        }
	        System.out.println(resultat.trim());
	}

}
