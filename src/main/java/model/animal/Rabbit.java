package model.animal;

import config.AnimalConfig;

public class Rabbit extends Animal implements Herbivore {
    private static final Animal rabbit;

    static {
        rabbit = AnimalConfig.getINSTANCE().getAnimalsProps().get("Rabbit");
    }

    public Rabbit() {
        super(rabbit.getName()
                , rabbit.getSymbol()
                , rabbit.getWeight()
                , rabbit.getCellsMove()
                , rabbit.getFoodSaturation());
    }
}
