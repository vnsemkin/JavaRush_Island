package model.plant;

import model.animal.Inhabitant;

public abstract class Plant extends Inhabitant {
    public Plant(String name, String symbol, float weight) {
        super(name, symbol, weight);
    }
}
