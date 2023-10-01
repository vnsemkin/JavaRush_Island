package model.animal;

import config.AnimalConfig;

public class Buffalo extends Animal implements Herbivore {
    private static final Animal buffalo;

    static {
        buffalo = AnimalConfig.getINSTANCE().getAnimalsProps().get("Buffalo");
    }

    public Buffalo() {
        super(buffalo.getName()
                , buffalo.getSymbol()
                , buffalo.getWeight()
                , buffalo.getCellsMove()
                , buffalo.getFoodSaturation());
    }
}
