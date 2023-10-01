package model.animal;

import com.fasterxml.jackson.annotation.JsonProperty;
import config.IslandConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Animal extends Inhabitant implements Raptor, Herbivore {
    @JsonProperty(IslandConstants.JSON_CELL_MOVE)
    private int cellsMove;
    private float foodSaturation;

    public Animal(String name, String symbol, float weight
            , int cellsMove, float foodSaturation) {
        super(name, symbol, weight);
        this.cellsMove = cellsMove;
        this.foodSaturation = foodSaturation;
    }
}