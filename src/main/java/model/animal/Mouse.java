package model.animal;

import config.AnimalConfig;

public class Mouse extends Animal implements Herbivore, Raptor {
    private static final Animal mouse;

    static {
        mouse = AnimalConfig.getINSTANCE().getAnimalsProps().get("Mouse");
    }

    public Mouse() {
        super(mouse.getName()
                , mouse.getSymbol()
                , mouse.getWeight()
                , mouse.getCellsMove()
                , mouse.getFoodSaturation());
    }
}
