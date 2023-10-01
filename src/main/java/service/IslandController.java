package service;

import config.IslandConstants;
import model.Island.Island;
import service.task.MoveTask;
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
        view.printIsland(island, IslandConstants.START_NEW_ISLAND);
    }

    public void animalEat() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::animalEat);
        view.printIsland(island, IslandConstants.ANIMAL_EAT);
    }

    public void animalMove() {
        island = moveTask.animalMove(island);
        view.printIsland(island, IslandConstants.ANIMAL_MOVE);
    }

    public void grassGrow() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::grassGrow);
        view.printIsland(island, IslandConstants.GRASS_GROW);
    }

    public void animalReproduction() {
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(cellController::animalReproduction);
        view.printIsland(island, IslandConstants.ANIMAL_REPRODUCTION);
    }
}
