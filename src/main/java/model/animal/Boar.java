package model.animal;


import config.AnimalConfig;

public class Boar extends Animal implements Herbivore, Raptor {
    private static final Animal bear;

    static {
        bear = AnimalConfig.getINSTANCE().getAnimalsProps().get("Boar");
    }

    public Boar() {
        super(bear.getName()
                , bear.getSymbol()
                , bear.getWeight()
                , bear.getCellsMove()
                , bear.getFoodSaturation());
    }
}
