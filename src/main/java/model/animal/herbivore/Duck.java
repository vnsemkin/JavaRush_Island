package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;
import model.animal.Raptor;


public class Duck extends Animal implements Herbivore, Raptor {
    public Duck() {
        super("Duck", "\uD83E\uDD86", 1
                , 4, 0.14F);
    }
}
