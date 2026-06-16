package com.combatrpg;

import java.util.Random;

public class Arme {
    private String nom;
    private int degatsMin;
    private int degatsMax;

    private final Random random = new Random();

    public Arme(String nom, int degatsMin, int degatsMax) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom de l'arme ne peut pas être vide.");
        }

        if (degatsMin < 0) {
            throw new IllegalArgumentException("Les dégâts minimum ne peuvent pas être négatifs.");
        }

        if (degatsMin > degatsMax) {
            throw new IllegalArgumentException("Les dégâts minimum ne peuvent pas être supérieurs aux dégâts maximum.");
        }

        this.nom = nom;
        this.degatsMin = degatsMin;
        this.degatsMax = degatsMax;
    }

    public String getNom() {
        return nom;
    }

    public int getDegatsMin() {
        return degatsMin;
    }

    public int getDegatsMax() {
        return degatsMax;
    }

    public int getDegatsArme() {
        return random.nextInt(degatsMax - degatsMin + 1) + degatsMin;
    }
}
