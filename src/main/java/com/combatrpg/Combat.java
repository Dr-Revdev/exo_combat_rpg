package com.combatrpg;

public class Combat {
    private Personnage combattant1;
    private Personnage combattant2;

    public Combat(Personnage combattant1, Personnage combattant2) {
        this.combattant1 = combattant1;
        this.combattant2 = combattant2;
    }

    private void attaquer(Personnage attaquant, Personnage defenseur) {
        if (!attaquant.estVivant()) {
            System.out.println(attaquant.getNom() + " est KO, il ne peut pas attaquer !");
            return;
        }

        if (!defenseur.estVivant()) {
            System.out.println(defenseur.getNom() + " est déjà KO.");
            return;
        }

        int degats = attaquant.getArme().getDegats();

        defenseur.recevoirDegat(degats);

        System.out.println(
            attaquant.getNom() + " attaque " +
            defenseur.getNom() + " avec " +
            attaquant.getArme().getNom() + " et inflige " +
            degats + " dégâts."
        );

        System.out.println(
            defenseur.getNom() + " a maintenant " +
            defenseur.getPointsDeVie() + " PV."
        );
    }

    public void lancerCombat() {
        System.out.println("Début du combat entre " + combattant1.getNom() + " et " + combattant2.getNom() + ".");

        while (combattant1.estVivant() && combattant2.estVivant()) {
            attaquer(combattant1, combattant2);

            if (combattant2.estVivant()) {
                attaquer(combattant2, combattant1);
            }
        }

        if (combattant1.estVivant()) {
            System.out.println(combattant1.getNom() + " remporte le combat !");
        } else {
            System.out.println(combattant2.getNom() + " remporte le combat !");
        }
    }
}
