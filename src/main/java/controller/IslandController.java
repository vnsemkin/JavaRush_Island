package controller;

import factory.IslandFactory;
import model.Island.Island;
import task.MoveTask;
import view.View;

import java.util.Collection;

/**
 * Class for managing island
 **/
public class IslandController {
    private final View view = new View();
    private final MoveTask moveTask = new MoveTask();
    private final IslandFactory islandFactory = new IslandFactory();
    private static Island island;
    private final CellController cellController = new CellController();

    {
        island = islandFactory.getInitialIsland();
    }

    public void printInitialIsland() {
        view.printIsland(island, "Start new Island!");
    }

    public void animalEat() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::animalEat);
        view.printIsland(island, "Animal Eat!");
    }

    public void animalMove() {
        island = moveTask.animalMove(island);
        view.printIsland(island, "Animal Move");
    }

    public void grassGrow() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::grassGrow);
        view.printIsland(island, "Grass Grow!");
    }

    public void animalReproduction() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::animalReproduction);
        view.printIsland(island, "Animal Reproduction!");
    }
}
