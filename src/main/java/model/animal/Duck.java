package model.animal;

import config.AnimalConfig;


public class Duck extends Animal implements Herbivore, Raptor {
    private static final Animal duck;

    static {
        duck = AnimalConfig.getINSTANCE().getAnimalsProps().get("Duck");
    }

    public Duck() {
        super(duck.getName()
                , duck.getSymbol()
                , duck.getWeight()
                , duck.getCellsMove()
                , duck.getFoodSaturation());
    }
}
