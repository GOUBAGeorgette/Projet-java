package controller;

import model.Etudiant;
import java.util.ArrayList;
import java.util.List;

public class EtudiantController {
    private List<Etudiant> etudiants;

    public EtudiantController() {
        this.etudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public void modifierEtudiant(String id, Etudiant nouvelEtudiant) {
        for (Etudiant e : etudiants) {
            if (e.getIdEtudiant().equals(id)) {
                e.setNom(nouvelEtudiant.getNom());
                e.setPrenom(nouvelEtudiant.getPrenom());
                e.setDateNaissance(nouvelEtudiant.getDateNaissance());
                break;
            }
        }
    }

    public void supprimerEtudiant(String id) {
        etudiants.removeIf(e -> e.getIdEtudiant().equals(id));
    }

    public List<Etudiant> listerEtudiants() {
        return etudiants;
    }
}
