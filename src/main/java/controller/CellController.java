package controller;

import task.EatTask;
import model.Island.Cell;
import task.GrassGrowTask;
import task.ReproductionTask;

/**
 * Class for managing animals in Cell
 **/
public class CellController {
    public void animalEat(Cell cell, EatTask eatTask) {
        eatTask.animalEat(cell);
    }

    public void grassGrow(Cell cell, GrassGrowTask grassGrowTask) {
        grassGrowTask.grassGrow(cell);
    }

    public void animalReproduction(Cell cell, ReproductionTask reproductionTask) {
        reproductionTask.animalReproduction(cell);
    }
}
