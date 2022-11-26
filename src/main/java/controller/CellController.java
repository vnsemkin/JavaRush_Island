package controller;

import task.EatTask;
import model.Island.Cell;
import task.GrassGrowTask;
import task.ReproductionTask;

/**
 * Class for managing animals in Cell
 **/
public class CellController {
    private final ReproductionTask reproductionTask = new ReproductionTask();
    private final EatTask eatTask = new EatTask();
    private final GrassGrowTask grassGrowTask = new GrassGrowTask();

    public void animalEat(Cell cell) {eatTask.animalEat(cell);}

    public void grassGrow(Cell cell) {
        grassGrowTask.grassGrow(cell);
    }

    public void animalReproduction(Cell cell) {
        reproductionTask.animalReproduction(cell);
    }
}
