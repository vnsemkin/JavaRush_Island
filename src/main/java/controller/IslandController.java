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
    private Island island = IslandFactory.getInitialIsland();
    private final MoveTask moveTask = new MoveTask();
    private final CellController cellController = new CellController();


    public void printInitialIsland() {
        System.out.println("Start new Island!");
        view.printIsland(island);
    }

    public void animalEat() {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.setCell(cell);
                cellController.animalEat();
            }
        }
        System.out.println("Animal Eat!");
        view.printIsland(island);
    }

    public void animalMove() {
        island = moveTask.animalMove(island);
        System.out.println("Animal Move");
        view.printIsland(island);
    }

    public void grassGrow() {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.setCell(cell);
                cellController.grassGrow();
            }
        }
        System.out.println("Grass Grow!");
        view.printIsland(island);
    }

    public void animalReproduction() {
        for (List<Cell> cellList : island.getIsland()) {
            for (Cell cell : cellList) {
                cellController.setCell(cell);
                cellController.animalReproduction();
            }
        }
        System.out.println("Reproduction!");
        view.printIsland(island);
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
