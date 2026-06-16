package com.combatrpg;

public class Personnage {
    private String nom;
    private int pointsDeVie;
    private Arme arme;

    public Personnage(String nom, int pointsDeVie, Arme arme) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.arme = arme;
    }
}
