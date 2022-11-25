package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;

public class Buffalo extends Animal implements Herbivore {
    public Buffalo() {
        super("Buffalo", "\uD83D\uDC03", 700, 3
                , 100);
    }
}
