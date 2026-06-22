package com.combatrpg;

public class Armure {
    String nom;
    int defense;

    public Armure(String nom, int defense) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom de l'armure ne peut pas être vide.");
        }

        if (defense < 0) {
            throw new IllegalArgumentException("La défense ne peut pas être négatifs.");
        }
        this.nom = nom;
        this.defense = defense;
    }

    public String getNom() {
        return nom;
    }

    public int getDefense() {
        return defense;
    }
}
