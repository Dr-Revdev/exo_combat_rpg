package com.combatrpg;

public abstract class Potion {
    private String nom;

    public Potion(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom de la potion ne peut pas être vide.");
        }
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract void utiliser(Personnage cible);
}
