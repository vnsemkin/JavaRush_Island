package model.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public abstract class Inhabitant implements Cloneable {
    protected String name;
    protected String symbol;
    protected float weight;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return symbol;
    }
}
