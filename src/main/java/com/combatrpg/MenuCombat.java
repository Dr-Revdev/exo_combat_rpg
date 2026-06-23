package com.combatrpg;

import java.util.Scanner;

public class MenuCombat {
    private final Scanner scanner;

    public MenuCombat() {
        scanner = new Scanner(System.in);
    }

    public ActionCombat demanderActionCombat() {
        while (true) { 
            System.out.println();
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Attaquer");
            System.out.println("2. Voir les statistiques");
            System.out.println("3. Fuir");
            System.out.println("Votre choix : ");

            String choix = scanner.nextLine();

            switch (choix) {
                case "1" -> {return ActionCombat.ATTAQUER;}
                case "2" -> {return ActionCombat.VOIR_STATS;}
                case "3" -> {return  ActionCombat.FUIR;}
                default -> {System.out.println("Choix invalide.");}
                    
            }
        }
    }
}
