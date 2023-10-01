package model.animal;

import config.AnimalConfig;

public class Wolf extends Animal implements Raptor {
    private static final Animal wolf;

    static {
        wolf = AnimalConfig.getINSTANCE().getAnimalsProps().get("Wolf");
    }

    public Wolf() {
        super(wolf.getName()
                , wolf.getSymbol()
                , wolf.getWeight()
                , wolf.getCellsMove()
                , wolf.getFoodSaturation());
    }
}
