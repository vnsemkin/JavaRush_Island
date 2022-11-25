package model.animal.raptor;

import model.animal.Animal;
import model.animal.Raptor;

public class Snake extends Animal implements Raptor {
    public Snake() {
        super("Snake", "\uD83D\uDC0D", 15
                , 1, 3);
    }
}
