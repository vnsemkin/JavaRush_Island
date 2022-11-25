package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;

public class Caterpillar extends Animal implements Herbivore {
    public Caterpillar() {
        super("Caterpillar", "\uD83D\uDC1B", 0.01F
                , 0, 0);
    }
}
