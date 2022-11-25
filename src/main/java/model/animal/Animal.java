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

    public void setCellsMove(int cellsMove) {
        this.cellsMove = cellsMove;
    }

    public float getFoodSaturation() {
        return foodSaturation;
    }

    public void setFoodSaturation(float foodSaturation) {
        this.foodSaturation = foodSaturation;
    }
}