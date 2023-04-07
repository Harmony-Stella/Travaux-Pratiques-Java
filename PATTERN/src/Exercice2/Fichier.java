package Exercice2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fichier extends JFrame {
    private JMenu menuFichier;
    private JMenuItem menuOuvrir, menuSauvegarder, menuFermer;
    private JMenu menuEdition;
    private JMenuItem menuCopier, menuColler;
    private String fichierOuvert;

    public Fichier() {
        super("Exemple de menus");
        MenuInterface();
    }

    private void MenuInterface() {
        JMenuBar menuBar = new JMenuBar();
        menuFichier = new JMenu("Fichier");
        menuOuvrir = new JMenuItem("Ouvrir");
        menuSauvegarder = new JMenuItem("Sauvegarder");
        menuFermer = new JMenuItem("Fermer");
        menuEdition = new JMenu("Edition");
        menuCopier = new JMenuItem("Copier");
        menuColler = new JMenuItem("Coller");

        // option Ouvrir
        menuOuvrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomFichier = JOptionPane.showInputDialog("Nom du fichier à ouvrir :");
                if (fichierOuvert != null) {
                    System.out.println("Fermeture de " + fichierOuvert);
                }
                System.out.println("Ouverture de " + nomFichier);
                fichierOuvert = nomFichier;
            }
        });

        // option Sauvegarder
        menuSauvegarder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fichierOuvert == null) {
                    System.out.println("Aucun fichier ouvert à sauvegarder");
                } else {
                    System.out.println("Sauvegarde de " + fichierOuvert);
                }
            }
        });

        // option Fermer
        menuFermer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fichierOuvert == null) {
                    System.out.println("Aucun fichier ouvert à fermer");
                } else {
                    System.out.println("Fermeture de " + fichierOuvert);
                    fichierOuvert = null;
                }
            }
        });

        // option Copier
        menuCopier.addActionListener(new ActionListener() {
        	private String copie;
            public void actionPerformed(ActionEvent e) {
                if(copie != null) {
                	System.out.println("Copie d'information");
                }else {
                	System.out.println("Pas de fichier ouvert, impossible de copier");
                }
            }
        });

        // option Coller
        menuColler.addActionListener(new ActionListener() {
        	private boolean coller = false ;
            public void actionPerformed(ActionEvent e) {
                if (fichierOuvert == null) {
                    System.out.println("Pas de fichier ouvert pour coller");
                } else if (!coller){
                    System.out.println("Collage d'information");
                    coller = true;
                }else {
                	 System.out.println("L'information a déjà été collée");
                }
            }
        });

        // Ajout des options aux menus
        menuFichier.add(menuOuvrir);
        menuFichier.add(menuSauvegarder);
        menuFichier.add(menuFermer);
        menuEdition.add(menuCopier);
        menuEdition.add(menuColler);

        // Ajout des menus à la barre de menu
        menuBar.add(menuFichier);
        menuBar.add(menuEdition);
        
        setJMenuBar(menuBar);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Fichier();
    }
}

