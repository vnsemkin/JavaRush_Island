package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;
import model.animal.Raptor;

public class Mouse extends Animal implements Herbivore, Raptor {
    public Mouse() {
        super("Mouse", "\uD83D\uDC01", 0.05F
                , 1, 0.01F);
    }
}
