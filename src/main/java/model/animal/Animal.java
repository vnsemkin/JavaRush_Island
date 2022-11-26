package model.animal;

public abstract class Animal extends Inhabitant implements Raptor, Herbivore {
    protected int cellsMove;
    protected float foodSaturation;

    public Animal(String name, String symbol, float weight
            , int cellsMove, float foodSaturation) {
        super(name, symbol, weight);
        this.cellsMove = cellsMove;
        this.foodSaturation = foodSaturation;
    }

    public int getCellsMove() {
        return cellsMove;
    }

}