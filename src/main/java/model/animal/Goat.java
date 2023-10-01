package model.animal;

import config.AnimalConfig;

public class Goat extends Animal implements Herbivore {
    private static final Animal goat;

    static {
        goat = AnimalConfig.getINSTANCE().getAnimalsProps().get("Goat");
    }

    public Goat() {
        super(goat.getName()
                , goat.getSymbol()
                , goat.getWeight()
                , goat.getCellsMove()
                , goat.getFoodSaturation());
    }
}
