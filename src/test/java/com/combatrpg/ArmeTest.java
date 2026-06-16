package com.combatrpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

class ArmeTest {

    @Test
    void getNomRetourneLeNomDeLArme() {
        Arme arme = new Arme("Epée coutre", 2,6);
        assertEquals("Epée coutre", arme.getNom());
    }

    @Test
    void getDegatsArmeRetourneUneValeurDansLaBonnePlage() {
        Arme arme = new Arme("Épée", 10, 15);

        int degats = arme.getDegatsArme();

        assertTrue(degats >= 10);
        assertTrue(degats <= 15);
    }

    @Test
    void constructeurRefuseDegatsMinSuperieursAuxDegatsMax() {
        try {
            Arme arme = new Arme("Épée cassée", 10, 5);

            fail("Le constructeur aurait dû refuser une arme avec degatsMin > degatsMax, mais il a créé : " + arme.getNom());
        } catch (IllegalArgumentException exception) {
            assertTrue(exception.getMessage() != null);
        }
    }

    @Test
    void constructeurRefuseDegatsMinNegatifs() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Arme("Dague", -1, 5)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void constructeurRefuseDegatsMaxNegatifs() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Arme("Hache rouillée", 1, -5)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void getDegatsArmeRenourneLaValeurUniqueQuandMinEgaleMax() {
        Arme arme = new Arme("Massue", 5, 5);

        int degats = arme.getDegatsArme();

        assertEquals(5, degats);
    }

    @Test
    void constructeurRefuseNomNull() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Arme(null, 1, 5)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void constructeurRefuseNomVide() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Arme("", 1, 5)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void constructeurRefuseNomAvecSeulementDesEspaces() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Arme("   ", 1, 5)
        );

        assertTrue(exception.getMessage() != null);
    }
}