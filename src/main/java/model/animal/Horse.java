package model.animal;

import config.AnimalConfig;

public class Horse extends Animal implements Herbivore {
    private static final Animal horse;

    static {
        horse = AnimalConfig.getINSTANCE().getAnimalsProps().get("Horse");
    }

    public Horse() {
        super(horse.getName()
                , horse.getSymbol()
                , horse.getWeight()
                , horse.getCellsMove()
                , horse.getFoodSaturation());
    }
}