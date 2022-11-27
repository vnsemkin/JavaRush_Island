package controller;

import factory.IslandFactory;
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
    private static Island island;
    private final CellController cellController = new CellController();

    {
        island = islandFactory.getInitialIsland();
    }

    public void printInitialIsland() {
        view.printIsland(island, "Start new Island!");
    }

    public void animalEat(EatTask eatTask) {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cell -> cellController.animalEat(cell, eatTask));
        view.printIsland(island, "Animal Eat!");
    }

    public void animalMove(MoveTask moveTask) {
        island = moveTask.animalMove(island);
        view.printIsland(island, "Animal Move");
    }

    public void grassGrow(GrassGrowTask grassGrowTask) {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cell -> cellController.grassGrow(cell, grassGrowTask));
        view.printIsland(island, "Grass Grow!");
    }

    public void animalReproduction(ReproductionTask reproductionTask) {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cell -> cellController.animalReproduction(cell, reproductionTask));
        view.printIsland(island, "Animal Reproduction!");
    }
}
