package com.combatrpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PersonnageTest {
    @Test
    void recevoirDegatDiminueLesPointsDeVie() {
        Arme arme = new Arme("Épée courte", 2, 6);
        Personnage personnage = new Personnage("Arthur", 100, arme);

        personnage.recevoirDegat(25);

        assertEquals(75, personnage.getPointsDeVie());
    }

    @Test
    void recevoirDegatNeDescendPasSousZero() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Personnage personnage = new Personnage("Arthur", 100, arme);

        personnage.recevoirDegat(150);

        assertEquals(0, personnage.getPointsDeVie());
    }

    @Test
    void estVivantRetourneTrueQuandLePersonnageADesPointDeVie() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Personnage personnage = new Personnage("Arthur", 100, arme);

        assertTrue(personnage.estVivant());
    }

    @Test
    void estVivantRetourneFalseQuandLePersonnageNaPasDePointsDeVie() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Personnage personnage = new Personnage("Arthur", 100, arme);

        personnage.recevoirDegat(150);

        assertFalse(personnage.estVivant());
    }

    @Test
    void constructeurRefusePointsDeVieNuls() {
        Arme arme = new Arme("Epée courte", 2, 6);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Personnage("Arthur", 0, arme)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void constructeurRefuseArmeNull() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Personnage("Arthur", 100, null)
        );

        assertTrue(exception.getMessage() != null);
    }
}
