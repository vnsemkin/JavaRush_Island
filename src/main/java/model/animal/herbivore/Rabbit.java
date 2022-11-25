package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;

public class Rabbit extends Animal implements Herbivore {
    public Rabbit() {
        super("Rabbit", "\uD83D\uDC30"
                , 2, 2, 0.45F);
    }
}
