package model.animal;

import config.AnimalConfig;

public class Caterpillar extends Animal implements Herbivore {
    private static final Animal caterpillar;

    static {
        caterpillar = AnimalConfig.getINSTANCE().getAnimalsProps().get("Caterpillar");
    }

    public Caterpillar() {
        super(caterpillar.getName()
                , caterpillar.getSymbol()
                , caterpillar.getWeight()
                , caterpillar.getCellsMove()
                , caterpillar.getFoodSaturation());
    }
}
