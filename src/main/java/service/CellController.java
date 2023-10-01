package service;

import service.task.EatTask;
import model.Island.Cell;
import service.task.GrassGrowTask;
import service.task.ReproductionTask;

/**
 * Class for managing animals in Cell
 **/
public class CellController {
    private final EatTask eatTask = new EatTask();
    private final GrassGrowTask grassGrowTask = new GrassGrowTask();
    private final ReproductionTask reproductionTask = new ReproductionTask();

    public void animalEat(Cell cell) {
        eatTask.animalEat(cell);
    }

    public void grassGrow(Cell cell) {
        grassGrowTask.grassGrow(cell);
    }

    public void animalReproduction(Cell cell) {
        reproductionTask.animalReproduction(cell);
    }
}
