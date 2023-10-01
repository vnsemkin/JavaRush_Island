package model.animal;

import config.AnimalConfig;

public class Bear extends Animal implements Raptor {
    private static final Animal bear;

    static {
        bear = AnimalConfig.getINSTANCE().getAnimalsProps().get("Bear");
    }

    public Bear() {
        super(bear.getName()
                , bear.getSymbol()
                , bear.getWeight()
                , bear.getCellsMove()
                , bear.getFoodSaturation());
    }
}
