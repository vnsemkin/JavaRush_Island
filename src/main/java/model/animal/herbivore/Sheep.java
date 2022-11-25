package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;

public class Sheep extends Animal implements Herbivore {
    public Sheep() {
        super("Sheep", "\uD83D\uDC11", 70
                , 3, 15);
    }
}
