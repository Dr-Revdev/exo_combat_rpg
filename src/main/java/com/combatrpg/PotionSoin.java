package com.combatrpg;

public class PotionSoin extends Potion {

    private int valeurSoin;

    public PotionSoin(String nom, int valeurSoin) {
        super(nom);
        if (valeurSoin <= 0) {
            throw new IllegalArgumentException("La valeur du soin doit ête supérieur à zéro");
        }
        this.valeurSoin = valeurSoin;
    }

    public int getValeurSoin() {
        return valeurSoin;
    }

    @Override
    public void utiliser(Personnage cible) {
        cible.seSoigner(valeurSoin);
    }

}
