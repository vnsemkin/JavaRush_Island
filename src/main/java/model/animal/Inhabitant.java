package model.animal;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
