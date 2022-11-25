package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;

public class Horse extends Animal implements Herbivore {
    public Horse() {
        super("Horse", "\uD83D\uDC0E", 400
                , 4, 60);
    }
}