package view;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.EtudiantController;
import model.Etudiant;

public class MainView {
    private JFrame frame;
    private EtudiantController etudiantController;
    private JTable table;
    private DefaultTableModel tableModel;

    public MainView(EtudiantController etudiantController) {
        this.etudiantController = etudiantController;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Gestion des Étudiants");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Ajouter le titre
        JLabel label = new JLabel("Bienvenue dans l'application de gestion des étudiants");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        // Ajouter le tableau pour afficher les étudiants
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nom", "Prénom", "Date de Naissance"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Ajouter le panneau de boutons
        JPanel panelBoutons = new JPanel();
        JButton btnAjouter = new JButton("Ajouter Étudiant");
        JButton btnModifier = new JButton("Modifier Étudiant");
        JButton btnSupprimer = new JButton("Supprimer Étudiant");
        panelBoutons.add(btnAjouter);
        panelBoutons.add(btnModifier);
        panelBoutons.add(btnSupprimer);
        frame.add(panelBoutons, BorderLayout.SOUTH);

        // Ajouter les écouteurs d'événements aux boutons
        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajouterEtudiant();
            }
        });

        btnModifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modifierEtudiant();
            }
        });

        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                supprimerEtudiant();
            }
        });

        frame.setVisible(true);
    }

    private void ajouterEtudiant() {
        String id = JOptionPane.showInputDialog("ID de l'étudiant:");
        String nom = JOptionPane.showInputDialog("Nom de l'étudiant:");
        String prenom = JOptionPane.showInputDialog("Prénom de l'étudiant:");
        String dateNaissance = JOptionPane.showInputDialog("Date de naissance (yyyy-MM-dd):");

        Etudiant etudiant = new Etudiant(id, nom, prenom, java.sql.Date.valueOf(dateNaissance));
        etudiantController.ajouterEtudiant(etudiant);
        rafraichirTable();
    }

    private void modifierEtudiant() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un étudiant à modifier.");
            return;
        }

        String id = (String) tableModel.getValueAt(row, 0);
        String nom = JOptionPane.showInputDialog("Nom de l'étudiant:", tableModel.getValueAt(row, 1));
        String prenom = JOptionPane.showInputDialog("Prénom de l'étudiant:", tableModel.getValueAt(row, 2));
        String dateNaissance = JOptionPane.showInputDialog("Date de naissance (yyyy-MM-dd):", tableModel.getValueAt(row, 3));

        Etudiant nouvelEtudiant = new Etudiant(id, nom, prenom, java.sql.Date.valueOf(dateNaissance));
        etudiantController.modifierEtudiant(id, nouvelEtudiant);
        rafraichirTable();
    }

    private void supprimerEtudiant() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un étudiant à supprimer.");
            return;
        }

        String id = (String) tableModel.getValueAt(row, 0);
        etudiantController.supprimerEtudiant(id);
        rafraichirTable();
    }

    private void rafraichirTable() {
        tableModel.setRowCount(0); // Effacer les données existantes
        for (Etudiant etudiant : etudiantController.listerEtudiants()) {
            tableModel.addRow(new Object[]{
                    etudiant.getIdEtudiant(),
                    etudiant.getNom(),
                    etudiant.getPrenom(),
                    etudiant.getDateNaissance().toString()
            });
        }
    }
}
