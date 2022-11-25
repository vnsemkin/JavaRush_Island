package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;

public class Deer extends Animal implements Herbivore {
    public Deer() {
        super("Deer", "\uD83E\uDD8C", 300
                , 4, 50);
    }
}
