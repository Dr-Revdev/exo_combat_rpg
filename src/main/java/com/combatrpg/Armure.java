package com.combatrpg;

public class Armure {
    String nom;
    int defense;

    public Armure(String nom, int defense) {
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
