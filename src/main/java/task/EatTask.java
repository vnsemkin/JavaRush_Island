package task;

import controller.IslandController;
import model.Island.Cell;
import model.animal.Animal;
import model.animal.Inhabitant;
import model.animal.InhabitantConfig;
import model.plant.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EatTask implements Runnable {
    private Cell cell;
    private final IslandController islandController = new IslandController();
    private final InhabitantConfig inhabitantConfig = new InhabitantConfig();

    public void animalEat(Cell cell) {
        this.cell = cell;
        for (int i = 0; i < cell.getAnimals().size(); i++) {
            getAnimalEat(cell.getAnimals().get(i));
        }
    }

    private void getAnimalEat(Animal hunter) {
        Map<Class<? extends Inhabitant>, Integer> victimMap =
                inhabitantConfig.fightProbabilityMap.get(hunter.getClass());
        for (Map.Entry<Class<? extends Inhabitant>, Integer> victimEntry : victimMap.entrySet()) {
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
            int randomProbability = threadLocalRandom.nextInt(100);
            if (victimEntry.getValue() != 0 && randomProbability >= victimEntry.getValue()
                    || victimEntry.getValue() == 100) {
                try {
                    removeAnimal(victimEntry.getKey().getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void removeAnimal(Inhabitant inhabitant) {
        if (inhabitant instanceof Animal) {
            for (Animal animal : cell.getAnimals()) {
                if (animal.getClass().equals(inhabitant.getClass())) {
                    cell.getAnimals().remove(animal);
                    break;
                }
            }
        } else {
            for (Plant plant : cell.getPlants()) {
                if (plant.getClass().equals(inhabitant.getClass())) {
                    cell.getPlants().remove(plant);
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        islandController.animalEat(this);
    }
}