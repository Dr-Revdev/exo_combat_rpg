package com.combatrpg;

public class Personnage {
    private String nom;
    private int pointsDeVie;
    private int pointsDeVieMaximum;
    private Arme arme;
    private Armure armure;

    public Personnage(String nom, int pointsDeVie, int pointsDeVieMaximum, Arme arme, Armure armure) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom du personnage ne peut pas être vide.");
        }

        if (pointsDeVie <= 0) {
            throw new IllegalArgumentException("Les points de vie doivent être supérieurs à 0.");
        }
     
        if (pointsDeVie > pointsDeVieMaximum) {
            throw new IllegalArgumentException("Les points de vie ne peuvent pas être supérieurs aux points de vie maximum.");
        }

        if (arme == null) {
            throw new IllegalArgumentException("Le personnage doit avoir une arme.");
        }

        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.pointsDeVieMaximum = pointsDeVieMaximum;
        this.arme = arme;
        this.armure = armure;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public Arme getArme() {
        return arme;
    }

    public Armure getArmure() {
        return armure;
    }

    public void recevoirDegat(int degats) {
        int defense = 0;

        if (armure != null) {
            defense = armure.getDefense();
        }

        int degatsReels = degats - defense;

        if (degatsReels < 0) {
            degatsReels = 0;
        }

        pointsDeVie = pointsDeVie - degatsReels;

        if (pointsDeVie < 0) {
            pointsDeVie = 0;
        }
    }

    public void seSoigner(int pointsDeSoin) {
        
        pointsDeVie = pointsDeVie + pointsDeSoin;

        if (pointsDeVie > pointsDeVieMaximum) {
            pointsDeVie = pointsDeVieMaximum;
        }
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}
