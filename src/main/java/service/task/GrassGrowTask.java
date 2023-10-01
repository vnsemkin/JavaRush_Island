package service.task;

import model.Island.Cell;
import config.InhabitantConfig;
import model.plant.Grass;

import java.util.concurrent.ThreadLocalRandom;

public class GrassGrowTask {
    private final InhabitantConfig inhabitantConfig = new InhabitantConfig();

    public void grassGrow(Cell cell) {
        Grass grass = new Grass();
        int grassMaxNumber = inhabitantConfig.maxNumberOnCellMap.get(grass.getClass());
        int randomNumber = ThreadLocalRandom.current().nextInt(grassMaxNumber);
        for (int i = 0; i < randomNumber; i++) {
            cell.getPlants().add(new Grass());
        }
    }
}
