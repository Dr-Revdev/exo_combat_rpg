package com.combatrpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
