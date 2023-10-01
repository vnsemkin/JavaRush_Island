package model.animal;

import config.AnimalConfig;

public class Deer extends Animal implements Herbivore {
    private static final Animal deer;

    static {
        deer = AnimalConfig.getINSTANCE().getAnimalsProps().get("Deer");
    }

    public Deer() {
        super(deer.getName()
                , deer.getSymbol()
                , deer.getWeight()
                , deer.getCellsMove()
                , deer.getFoodSaturation());
    }
}
