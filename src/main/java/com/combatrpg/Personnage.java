package com.combatrpg;

public class Personnage {
    private String nom;
    private int pointsDeVie;
    private Arme arme;

    public Personnage(String nom, int pointsDeVie, Arme arme) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom du personnage ne peut pas être vide.");
        }

        if (pointsDeVie <= 0) {
            throw new IllegalArgumentException("Les points de vie doivent être supérieurs à 0.");
        }

        if (arme == null) {
            throw new IllegalArgumentException("Le personnage doit avoir une arme.");
        }

        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.arme = arme;
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

    public void recevoirDegat(int degats) {
        pointsDeVie = pointsDeVie - degats;

        if (pointsDeVie < 0) {
            pointsDeVie = 0;
        }
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}
