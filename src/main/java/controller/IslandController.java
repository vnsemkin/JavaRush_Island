package controller;

import factory.IslandFactory;
import model.Island.Cell;
import model.Island.Island;
import task.MoveTask;
import view.View;

import java.util.*;
import java.util.concurrent.*;

/**
 * Class for managing island
 **/
public class IslandController implements Runnable {
    private final View view = new View();
    private final IslandFactory islandFactory = new IslandFactory();
    private Island island = islandFactory.getInitialIsland();
    private final MoveTask moveTask = new MoveTask();
    private final CellController cellController = new CellController();


    public void printInitialIsland() {
        view.printIsland(island, "Start new Island!");
    }

    public void animalEat() {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.animalEat(cell);
            }
        }
        view.printIsland(island, "Animal Eat!");
    }

    public void animalMove() {
        island = moveTask.animalMove(island);
        view.printIsland(island, "Animal Move");
    }

    public void grassGrow() {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.grassGrow(cell);
            }
        }
        view.printIsland(island, "Grass Grow!");
    }

    public void animalReproduction() {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.animalReproduction(cell);
            }
        }
        view.printIsland(island, "Animal Reproduction!");
    }

    @Override
    public void run() {
        printInitialIsland();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(this::animalEat, 0, 9, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(this::grassGrow, 3, 12, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(this::animalMove, 6, 15, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(this::animalReproduction, 9, 18, TimeUnit.SECONDS);
    }
}
