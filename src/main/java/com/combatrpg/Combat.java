package com.combatrpg;

public class Combat {
    private Personnage combattant1;
    private Personnage combattant2;
    private MenuCombat menuCombat;

    

    public Combat(Personnage combattant1, Personnage combattant2, MenuCombat menuCombat) {
        this.combattant1 = combattant1;
        this.combattant2 = combattant2;
        this.menuCombat = menuCombat;
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

        Arme arme = attaquant.getArme();

        if (arme == null) {
            System.out.println(attaquant.getNom() + " n'a pas d'arme et ne peut pas attaquer.");
            return;
        }

        int degats = arme.getDegatsArme();

        defenseur.recevoirDegat(degats);

        System.out.println(
            attaquant.getNom() + " attaque " +
            defenseur.getNom() + " avec " +
            arme.getNom() + " et inflige " +
            degats + " dégâts."
        );

        System.out.println(
            defenseur.getNom() + " a maintenant " +
            defenseur.getPointsDeVie() + " PV."
        );
    }

    public void lancerCombat() {
        int compteurTour = 1;
        System.out.println("Début du combat entre " + combattant1.getNom() + " et " + combattant2.getNom() + ".");
        

        while (combattant1.estVivant() && combattant2.estVivant()) {
            System.out.println("====================================== Tour " + compteurTour + " ==============================================");

            ActionCombat action = menuCombat.demanderActionCombat();
            System.out.println("Action choisie : " + action);

            switch (action) {
                case ATTAQUER:
                    attaquer(combattant1, combattant2);
                    if (combattant2.estVivant()) {
                        attaquer(combattant2, combattant1);
                    }
                    break;
                case VOIR_STATS:
                    System.out.println("Statistique du premier combattant");
                    afficherStatsCombattant(combattant1);
                    System.out.println();
                    System.out.println("Statistique du second combattant");
                    afficherStatsCombattant(combattant2);

                    continue;

                case FUIR:
                    System.out.println("Arthur fuit le combat");
                    return;

                default:
                    System.out.println("N'est pas une action valide");
                    continue;
            }

            compteurTour += 1;
        }

        if (combattant1.estVivant()) {
            System.out.println(combattant1.getNom() + " remporte le combat !");
        } else {
            System.out.println(combattant2.getNom() + " remporte le combat !");
        }
    }

    private void afficherStatsCombattant(Personnage combattant) {
        System.out.println("Nom : " + combattant.getNom());
        System.out.println("PV : " + combattant.getPointsDeVie());
        System.out.println("Arme : " + combattant.getArme().getNom());
        System.out.println("Dégâts arme : " + combattant.getArme().getDegatsMin() + "-" + combattant.getArme().getDegatsMax());
        if (combattant.getArmure() != null && !combattant.getArmure().getNom().isBlank()) {
            System.out.println("Armure : " + combattant.getArmure().getNom());
            System.out.println("Protection : " + combattant.getArmure().getDefense());
        }
    }
}
