package com.combatrpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmeTest {

    @Test
    void getDegatsArmeRetourneUneValeurDansLaBonnePlage() {
        Arme arme = new Arme("Épée", 10, 15);

        int degats = arme.getDegatsArme();

        assertTrue(degats >= 10);
        assertTrue(degats <= 15);
    }
}