package model.animal;

import config.AnimalConfig;

public class Sheep extends Animal implements Herbivore {
    private static final Animal sheep;

    static {
        sheep = AnimalConfig.getINSTANCE().getAnimalsProps().get("Sheep");
    }

    public Sheep() {
        super(sheep.getName()
                , sheep.getSymbol()
                , sheep.getWeight()
                , sheep.getCellsMove()
                , sheep.getFoodSaturation());
    }
}
