package task;

import controller.IslandController;
import model.Island.Cell;
import model.animal.InhabitantConfig;
import model.plant.Grass;

import java.util.concurrent.ThreadLocalRandom;

public class GrassGrowTask implements Runnable {
    private final InhabitantConfig inhabitantConfig = new InhabitantConfig();
    private final IslandController islandController = new IslandController();

    public void grassGrow(Cell cell) {
        Grass grass = new Grass();
        int grassMaxNumber = inhabitantConfig.maxNumberOnCellMap.get(grass.getClass());
        int randomNumber = ThreadLocalRandom.current().nextInt(grassMaxNumber);
        for (int i = 0; i < randomNumber; i++) {
            cell.getPlants().add(new Grass());
        }
    }

    @Override
    public void run() {
        islandController.grassGrow(this);
    }
}
