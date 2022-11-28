package task;

import model.Island.Cell;
import model.animal.Animal;
import model.animal.Inhabitant;
import model.animal.InhabitantConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class ReproductionTask  {
    private final InhabitantConfig inhabitantConfig = new InhabitantConfig();

    public void animalReproduction(Cell cell) {
        for (Class<? extends Inhabitant> animalClass : inhabitantConfig.inhabitantClassList) {
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
}
