package model.animal;

import config.AnimalConfig;

public class Eagle extends Animal implements Raptor {
    private static final Animal eagle;

    static {
        eagle = AnimalConfig.getINSTANCE().getAnimalsProps().get("Eagle");
    }

    public Eagle() {
        super(eagle.getName()
                , eagle.getSymbol()
                , eagle.getWeight()
                , eagle.getCellsMove()
                , eagle.getFoodSaturation());
    }
}
