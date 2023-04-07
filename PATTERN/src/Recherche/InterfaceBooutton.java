package Recherche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceBooutton implements ActionListener {

    private JFrame frame;
    private JButton button;

    public InterfaceBooutton() {
        frame = new JFrame("Swing Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Cliquez ici !");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(button);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "Bonjour, voici un exemple de texte !");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfaceBooutton();
            }
        });
    }
}
