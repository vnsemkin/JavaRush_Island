package task;

import model.Island.Cell;
import model.animal.InhabitantConfig;
import model.plant.Grass;

import java.util.concurrent.ThreadLocalRandom;

public class GrassGrowTask {
    public void grassGrow(Cell cell) {
        Grass grass = new Grass();
        int grassMaxNumber = InhabitantConfig.maxNumberOnCellMap.get(grass.getClass());
        int randomNumber = ThreadLocalRandom.current().nextInt(grassMaxNumber);
        for (int i = 0; i < randomNumber; i++) {
            cell.getPlants().add(new Grass());
        }
    }
}
