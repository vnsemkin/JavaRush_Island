package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;

public class Goat extends Animal implements Herbivore {
    public Goat() {
        super("Goat", "\uD83D\uDC10", 60
                , 3, 10);
    }
}
