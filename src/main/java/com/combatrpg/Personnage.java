package com.combatrpg;

public class Personnage {
    private String nom;
    private int pointsDeVie;
    private int pointsDeVieMaximum;
    private int force;
    private int vitesse;
    private Arme arme;
    private Armure armure;

    public Personnage(String nom, int pointsDeVie, int pointsDeVieMaximum, int force, int vitesse, Arme arme, Armure armure) {
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

        if (force < 0) {
            throw new IllegalArgumentException("La statistique de foce doit être supérieur à zéro.");
        }

        if (vitesse < 0) {
            throw new IllegalArgumentException("La statistique de vitesse doit être supérieur à zéro.");
        }

        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.pointsDeVieMaximum = pointsDeVieMaximum;
        this.arme = arme;
        this.armure = armure;
        this.force = force;
        this.vitesse = vitesse;
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

    public int getForce() {
        return force;
    }

    public int getVitesse() {
        return vitesse;
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

    public int calculerBonusDegatsForce() {
        return (int) Math.ceil(force * 0.20);
    }
}
