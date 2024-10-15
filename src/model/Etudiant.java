package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Etudiant {
    private String idEtudiant;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private List<Cours> coursSuivis;

    public Etudiant(String idEtudiant, String nom, String prenom, Date dateNaissance) {
        this.idEtudiant = idEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.coursSuivis = new ArrayList<>();
    }

    // Getters et setters
    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Cours> getCoursSuivis() {
        return coursSuivis;
    }

    public void ajouterCours(Cours cours) {
        coursSuivis.add(cours);
    }

    public void supprimerCours(Cours cours) {
        coursSuivis.remove(cours);
    }
}
