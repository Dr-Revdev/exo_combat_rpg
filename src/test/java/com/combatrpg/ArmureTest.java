package com.combatrpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ArmureTest {
    @Test
    void getNomRetourneLeNomDeLArmure() {
        Armure armure = new Armure("Armure de cuir", 2);
        assertEquals("Armure de cuir", armure.getNom());
    }

    @Test
    void getDefenseRetourneLaDefenseDeLArmure() {
        Armure armure = new Armure("Armure de peau", 2);
        assertEquals(2, armure.getDefense());
    }

    @Test
    void constructeurRefuseNomNull() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Armure(null, 1)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void constructeurRefuseNomVide() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Armure("", 2)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void constructeurRefuseNomAvecSeulementDesEspaces() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Armure("   ", 5)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void constructeurRefuseDefenseInferieurZero() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> new Armure("Armure d'acier", -1)
        );

        assertTrue(exception.getMessage() != null);
    }
}
