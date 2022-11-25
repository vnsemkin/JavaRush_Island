package controller;

import task.EatTask;
import model.Island.Cell;
import task.GrassGrowTask;
import task.ReproductionTask;

/**
 * Class for managing animals in Cell
 **/
public class CellController {
    private Cell cell;
    private final ReproductionTask reproductionTask = new ReproductionTask();
    private final EatTask eatTask = new EatTask();
    private final GrassGrowTask grassGrowTask = new GrassGrowTask();

    public void animalEat() {
        eatTask.setCell(cell);
        eatTask.animalEat();
    }

    public void grassGrow() {
        grassGrowTask.grassGrow(cell);
    }

    public void animalReproduction() {
        reproductionTask.animalReproduction(cell);
    }


    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
