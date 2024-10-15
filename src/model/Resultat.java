package model;

public class Resultat {
    private Etudiant etudiant;
    private Cours cours;
    private double note;
    private String semestre;
    private boolean valide;

    public Resultat(Etudiant etudiant, Cours cours, double note, String semestre) {
        this.etudiant = etudiant;
        this.cours = cours;
        this.note = note;
        this.semestre = semestre;
        this.valide = note >= 10.0;
    }

    // Getters et setters
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
        this.valide = note >= 10.0;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public boolean isValide() {
        return valide;
    }
}
