package view;

import model.Island.Cell;
import model.Island.Island;
import model.animal.Inhabitant;
import model.animal.InhabitantConfig;
import model.plant.Grass;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class View {
    InhabitantConfig inhabitantConfig = new InhabitantConfig();

    public void printIsland(Island island, String taskName) {
        System.out.println(taskName);
        island.getIsland().stream()
                .flatMap(Collection::stream)
                .forEach(this::print);
        System.out.println("<------------------------------Next Generation----------------------------->");
    }

    private void print(Cell cell) {
        Grass grass = new Grass();
        Map<String, Integer> cellMap;
        cellMap = new HashMap<>();
        int count;
        for (Class<? extends Inhabitant> inhabitantClass : inhabitantConfig.inhabitantClassList) {
            count = cell.getAnimals().stream()
                    .mapToInt(value -> value.getClass().equals(inhabitantClass) ? 1 : 0)
                    .sum();
            try {
                cellMap.put(inhabitantClass.getConstructor().newInstance().getSymbol(), count);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        cellMap.put(grass.getSymbol(), cell.getPlants().size());
        System.out.println(cellMap);
    }
}
