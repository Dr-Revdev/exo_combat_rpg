package com.combatrpg;

public class Main {
    public static void main(String[] args) {
        Arme epee = new Arme("Épée", 10, 17);
        Arme hache = new Arme("Hache", 15, 17);

        Personnage arthur = new Personnage("Arthur", 100, epee, null);
        Personnage thorgrim = new Personnage("Thorgrim", 100, hache, null);

        Combat combat = new Combat(arthur, thorgrim);

        combat.lancerCombat();
    }
}