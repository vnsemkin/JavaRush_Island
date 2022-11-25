package model.animal.raptor;

import model.animal.Animal;
import model.animal.Raptor;

public class Bear extends Animal implements Raptor {
    public Bear() {
        super("Bear", "\uD83D\uDC3B", 500
                , 2, 2);
    }
}
