package com.combatrpg;

public class Main {
    public static void main(String[] args) {
        Arme epee = new Arme("Épée", 10, 17);
        Arme hache = new Arme("Hache", 15, 17);

        Personnage arthur = new Personnage("Arthur", 100, 100, 10, 11, epee, null);
        Personnage thorgrim = new Personnage("Thorgrim", 100, 100, 10, 11, hache, null);

        MenuCombat menuCombat = new MenuCombat();

        Combat combat = new Combat(arthur, thorgrim, menuCombat);

        combat.lancerCombat();
    }
}