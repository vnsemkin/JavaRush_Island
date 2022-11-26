package controller;

import factory.IslandFactory;
import model.Island.Cell;
import model.Island.Island;
import task.EatTask;
import task.GrassGrowTask;
import task.MoveTask;
import task.ReproductionTask;
import view.View;

import java.util.*;

/**
 * Class for managing island
 **/
public class IslandController {
    private final View view = new View();
    private final IslandFactory islandFactory = new IslandFactory();
    private Island island = islandFactory.getInitialIsland();
    private final CellController cellController = new CellController();


    public void printInitialIsland() {
        view.printIsland(island, "Start new Island!");
    }

    public void animalEat(EatTask eatTask) {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.animalEat(cell, eatTask);
            }
        }
        view.printIsland(island, "Animal Eat!");
    }

    public void animalMove(MoveTask moveTask) {
        island = moveTask.animalMove(island);
        view.printIsland(island, "Animal Move");
    }

    public void grassGrow(GrassGrowTask grassGrowTask) {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.grassGrow(cell, grassGrowTask);
            }
        }
        view.printIsland(island, "Grass Grow!");
    }

    public void animalReproduction(ReproductionTask reproductionTask) {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.animalReproduction(cell, reproductionTask);
            }
        }
        view.printIsland(island, "Animal Reproduction!");
    }
}
