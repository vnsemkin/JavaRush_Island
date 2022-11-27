package factory;

import model.Island.Cell;
import model.animal.Animal;
import model.animal.InhabitantConfig;
import model.animal.Inhabitant;
import model.plant.Plant;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Cell creation class
 **/
public class CellFactory {
    private final InhabitantConfig inhabitantConfig = new InhabitantConfig();

    public Cell createCell() {
        Cell cell = new Cell();
        int number;
        int maxNumberOnCell = 0;
        for (Class<? extends Inhabitant> inhabitantClass : inhabitantConfig.inhabitantClassList) {
            Inhabitant inhabitant;
            try {
                inhabitant = inhabitantClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            for (Map.Entry<Class<? extends Inhabitant>, Integer> maxNumberOnCellEntry : inhabitantConfig.maxNumberOnCellMap.entrySet()) {
                if (inhabitantClass.equals(maxNumberOnCellEntry.getKey())) {
                    maxNumberOnCell = maxNumberOnCellEntry.getValue();
                    break;
                }
            }
            number = (int) (Math.random() * maxNumberOnCell);
            for (int i = 0; i <= number; i++) {
                try {
                    if (inhabitant instanceof Animal) {
                        cell.getAnimals().add((Animal) inhabitant.clone());
                    } else {
                        cell.getPlants().add((Plant) inhabitant.clone());
                    }
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return cell;
    }
}