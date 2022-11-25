package model.animal;

public abstract class Inhabitant implements Cloneable {
    protected String name;
    protected String symbol;
    protected float weight;

    public Inhabitant(String name, String symbol, float weight) {
        this.name = name;
        this.symbol = symbol;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return symbol;
    }
}
