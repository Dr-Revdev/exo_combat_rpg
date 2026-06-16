package com.combatrpg;

public class Main {
    public static void main(String[] args) {
        Arme epee = new Arme("Épée", 10);
        Arme hache = new Arme("Hache", 15);

        Personnage arthur = new Personnage("Arthur", 100, epee);
        Personnage thorgrim = new Personnage("Thorgrim", 100, hache);

        Combat combat = new Combat(arthur, thorgrim);

        combat.lancerCombat();
    }
}