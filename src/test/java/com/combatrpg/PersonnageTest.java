package com.combatrpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class PersonnageTest {
    @Test
    void recevoirDegatDiminueLesPointsDeVie() {
        Arme arme = new Arme("Épée courte", 2, 6);
        Personnage personnage = new Personnage("Arthur", 100, 100, 10, 11, arme, null);

        personnage.recevoirDegat(25);

        assertEquals(75, personnage.getPointsDeVie());
    }

    @Test
    void recevoirDegatNeDescendPasSousZero() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Personnage personnage = new Personnage("Arthur", 100, 100, 10, 11, arme, null);

        personnage.recevoirDegat(150);

        assertEquals(0, personnage.getPointsDeVie());
    }

    @Test
    void estVivantRetourneTrueQuandLePersonnageADesPointDeVie() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Personnage personnage = new Personnage("Arthur", 100, 100, 10, 11, arme, null);

        assertTrue(personnage.estVivant());
    }

    @Test
    void estVivantRetourneFalseQuandLePersonnageNaPasDePointsDeVie() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Personnage personnage = new Personnage("Arthur", 100, 100, 10, 11, arme, null);

        personnage.recevoirDegat(150);

        assertFalse(personnage.estVivant());
    }

    @Test
    void constructeurRefusePointsDeVieNuls() {
        Arme arme = new Arme("Epée courte", 2, 6);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Personnage("Arthur", 0, 100, 10, 11, arme, null)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void constructeurRefuseArmeNull() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Personnage("Arthur", 100, 100, 10, 11, null, null)
        );

        assertTrue(exception.getMessage() != null);
    }

    @Test
    void recevoirDegatPrendEnCompteLArmure() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Armure armure = new Armure("Cotte de mailles", 5);
        Personnage personnage = new Personnage("Arthur", 100, 100, 10, 11, arme, armure);

        personnage.recevoirDegat(20);

        assertEquals(85, personnage.getPointsDeVie());
    }

    @Test
    void constructeurRefusePointsDeVieSuperieursAuxPointsDeVieMaximum() {
        try {
            Arme arme = new Arme("Epée courte", 2, 6);
            Armure armure = new Armure("Cotte de mailles", 5);
            Personnage personnage = new Personnage("Arthur", 200, 100, 10, 11, arme, armure);

            fail("Le constructeur aurait dû refuser un personnage avec pointDeVie > pointsDeVieMaximum, mais il a créé : " + personnage.getNom());
        } catch (IllegalArgumentException exception) {
            assertTrue(exception.getMessage() != null);
        }
    }

    @Test
    void potionDeSoinModifieLesPointsDeVie() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Armure armure = new Armure("Cotte de mailles", 5);
        Personnage personnage = new Personnage("Arthur", 50, 100, 10, 11, arme, armure);
        Potion potionSoin = new PotionSoin("Potion de soin", 10);

        potionSoin.utiliser(personnage);

        assertEquals(60, personnage.getPointsDeVie());

    }

    @Test
    void pointDeVieEgalesPointsDeVieMaximumQuandSoinsSuperieurAPointsDeVieMaximum() {
        Arme arme = new Arme("Epée courte", 2, 6);
        Armure armure = new Armure("Cotte de mailles", 5);
        Personnage personnage = new Personnage("Arthur", 90, 100, 10, 11, arme, armure);
        Potion potionSoin = new PotionSoin("Potion de soin", 20);

        potionSoin.utiliser(personnage);

        assertEquals(100, personnage.getPointsDeVie());
    }

    @Test
    void leBonusDeDegatRenvoiVingtPourCentSup() {
        Arme arme = new Arme("Epée courte", 1, 1);
        Armure armure = new Armure("Cotte de mailles", 5);
        Personnage personnage = new Personnage("Arthur", 90, 100, 10, 11, arme, armure);

        assertEquals(2, personnage.calculerBonusDegatsForce());
    }
}
