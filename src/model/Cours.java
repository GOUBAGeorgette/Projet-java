package model;

import java.util.ArrayList;
import java.util.List;

public class Cours {
    private String codeCours;
    private String nomCours;
    private String professeur;
    private List<Etudiant> etudiantsInscrits;

    public Cours(String codeCours, String nomCours, String professeur) {
        this.codeCours = codeCours;
        this.nomCours = nomCours;
        this.professeur = professeur;
        this.etudiantsInscrits = new ArrayList<>();
    }

    // Getters et setters
    public String getCodeCours() {
        return codeCours;
    }

    public void setCodeCours(String codeCours) {
        this.codeCours = codeCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public List<Etudiant> getEtudiantsInscrits() {
        return etudiantsInscrits;
    }

    public void inscrireEtudiant(Etudiant etudiant) {
        etudiantsInscrits.add(etudiant);
    }

    public void desinscrireEtudiant(Etudiant etudiant) {
        etudiantsInscrits.remove(etudiant);
    }
}
