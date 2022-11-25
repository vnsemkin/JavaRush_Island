package model.animal.herbivore;

import model.animal.Animal;
import model.animal.Herbivore;
import model.animal.Raptor;


public class Boar extends Animal implements Herbivore, Raptor {
    public Boar() {
        super("Boar", "\uD83D\uDC17", 400
                , 2, 50);
    }
}
