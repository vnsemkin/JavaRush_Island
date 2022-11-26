package task;

import controller.IslandController;
import model.Island.Cell;
import model.animal.Animal;
import model.animal.Inhabitant;
import model.animal.InhabitantConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class ReproductionTask implements Runnable {
    private final IslandController islandController = new IslandController();

    public void animalReproduction(Cell cell) {
        for (Class<? extends Inhabitant> animalClass : InhabitantConfig.inhabitantClassList) {
            for (int i = 0; i < cell.getAnimals().size(); i++) {
                boolean isReproduction = ThreadLocalRandom.current().nextBoolean();
                if (animalClass.equals(cell.getAnimals().get(i).getClass()) && isReproduction) {
                    try {
                        cell.getAnimals().add((Animal) animalClass.getConstructor().newInstance());
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    @Override
    public void run() {
        islandController.animalReproduction(this);
    }
}
