package Traducteur;

import java.util.*;

public class FrancaisAnglais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le dictionnaire. Pour le moment je ne connais rien, aidez-moi à devenir intelligent.");

        while (true) {
            System.out.println("Instructions : ");
            System.out.println("Tapez 1 pour m’apprendre de nouveaux mots/phrases");
            System.out.println("Tapez 2 pour me demander la traduction d’un mot/phrase");
            System.out.println("Tapez 3 pour quitter");

            int choix = scanner.nextInt();

            if (choix == 1) {
                System.out.println("Entrez un mot/phrase en français : ");
                String motFrancais = scanner.next();

                if (Francais.connaitMot(motFrancais)) {
                    System.out.println("Je connais déjà ce mot/phrase");
                } else {
                    Francais.ajouterMot(motFrancais);
                    System.out.println("Entrez la traduction du mot/phrase en anglais : ");
                    String traduction = scanner.next();
                    Anglais.ajouterTraduction(motFrancais, traduction);
                }

            } else if (choix == 2) {
                if (Francais.isEmpty()) {
                    System.out.println("Pour le moment je ne connais rien");
                } else {
                    System.out.println("Entrez le mot ou la phrase à traduire : ");
                    String motFrancais = scanner.next();
                    String traduction = Anglais.traduire(motFrancais);
                    if (traduction != null) {
                        System.out.println("Traduction Français => Anglais : " + traduction);
                    } else {
                        System.out.println("Je ne connais pas. Pouvez-vous me donner la traduction pour les prochaines fois ?");
                        String nouvelleTraduction = scanner.next();
                        Anglais.ajouterTraduction(motFrancais, nouvelleTraduction);
                    }
                }

            } else if (choix == 3) {
                System.out.println("Bye.");
                break;
            } else {
                System.out.println("Choix invalide");
            }
        }

        scanner.close();
    }
}