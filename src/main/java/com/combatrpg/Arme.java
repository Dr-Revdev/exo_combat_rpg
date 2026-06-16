package com.combatrpg;

import java.util.Random;

public class Arme {
    private String nom;
    private int degatsMin;
    private int degatsMax;

    private final Random random = new Random();

    public Arme(String nom, int degatsMin, int degatsMax) {
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
