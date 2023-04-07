package Recherche;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Crud implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JLabel nameLabel, ageLabel, emailLabel;
    private JTextField nameField, ageField, emailField;
    private JButton addButton, deleteButton, updateButton;
    private Connection connection;

    public Crud() {
        frame = new JFrame("Swing JDBC CRUD Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Connexion à la base de données
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ma_base_de_donnees", "nom_utilisateur", "mot_de_passe");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Création du tableau
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nom", "Âge", "Email"}, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        scrollPane = new JScrollPane(table);

        // Création des champs de saisie et des étiquettes
        nameLabel = new JLabel("Nom:");
        ageLabel = new JLabel("Âge:");
        emailLabel = new JLabel("Email:");
        nameField = new JTextField(10);
        ageField = new JTextField(10);
        emailField = new JTextField(10);

        // Création des boutons
        addButton = new JButton("Ajouter");
        addButton.addActionListener(this);
        deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(this);
        updateButton = new JButton("Modifier");
        updateButton.addActionListener(this);

        // Ajout des éléments à la fenêtre
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(ageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(ageField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(emailField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(addButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(deleteButton, gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(updateButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(scrollPane, gbc);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        // Récupération des données de la base de données
        retrieveData();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addData();
        } else if (e.getSource() == deleteButton) {
            deleteData();
        } else if (e.getSource() == updateButton) {
            updateData();
        }
    }

    private void retrieveData() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM personnes");
            while (resultSet.next()) {
                Object[] row = {resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getInt("age"), resultSet.getString("email")};
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addData() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String email = emailField.getText();

            String query = "INSERT INTO personnes(nom, age, email) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, email);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                Object[] row = {statement.getGeneratedKeys().getInt(1), name, age, email};
                tableModel.addRow(row);
                nameField.setText("");
                ageField.setText("");
                emailField.setText("");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void deleteData() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            int id = (int) tableModel.getValueAt(row, 0);
            String query = "DELETE FROM personnes WHERE id = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    tableModel.removeRow(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateData() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            try {
                int id = (int) tableModel.getValueAt(row, 0);
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String email = emailField.getText();

                String query = "UPDATE personnes SET nom = ?, age = ?, email = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, name);
                statement.setInt(2, age);
                statement.setString(3, email);
                statement.setInt(4, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    tableModel.setValueAt(name, row, 1);
                    tableModel.setValueAt(age, row, 2);
                    tableModel.setValueAt(email, row, 3);
                    nameField.setText("");
                    ageField.setText("");
                    emailField.setText("");
                }
            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Crud();
            }
        });
    }
}

