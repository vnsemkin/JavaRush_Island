package task;

import model.Island.Cell;
import model.animal.Animal;
import model.animal.Inhabitant;
import model.animal.InhabitantConfig;
import model.plant.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EatTask {
    Cell cell;

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void animalEat() {
        for (int i = 0; i < cell.getAnimals().size(); i++) {
            getAnimalEat(cell.getAnimals().get(i));
        }
    }

    private void getAnimalEat(Animal hunter) {
        Map<Class<? extends Inhabitant>, Integer> victimMap = InhabitantConfig.fightProbabilityMap.get(hunter.getClass());
        for (Map.Entry<Class<? extends Inhabitant>, Integer> victimEntry : victimMap.entrySet()) {
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
            int randomProbability = threadLocalRandom.nextInt(100);
            if (victimEntry.getValue() != 0 && randomProbability >= victimEntry.getValue() || victimEntry.getValue() == 100) {
                try {
                    removeAnimal(victimEntry.getKey().getConstructor().newInstance());
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void removeAnimal(Inhabitant inhabitant) {
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
}
