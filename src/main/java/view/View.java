package view;

import model.Island.Island;
import model.animal.Animal;
import model.animal.Inhabitant;
import model.animal.InhabitantConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class View {
    public void printIsland(Island island, String taskName) {
        int j;
        Map<String, Integer> cellMap;
        System.out.println(taskName);
        for (int i = 0; i < island.getX(); i++) {
            for (j = 0; j < island.getY(); j++) {
                cellMap = new HashMap<>();
                int animalSize = island.getIsland().get(i).get(j).getAnimals().size();
                int plantSize = island.getIsland().get(i).get(j).getPlants().size();
                int count;
                for (Class<? extends Inhabitant> animalClass : InhabitantConfig.maxNumberOnCellMap.keySet()) {
                    int k;
                    Inhabitant inhabitant = null;
                    count = 0;
                    for (k = 0; k < animalSize; k++) {
                        try {
                            inhabitant = animalClass.getConstructor().newInstance();
                        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException |
                                 IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                        if (inhabitant instanceof Animal) {
                            if (animalClass.equals(island.getIsland().get(i).get(j).getAnimals().get(k).getClass()))
                                count++;
                        }
                    }
                    assert inhabitant != null;
                    cellMap.put(inhabitant.getSymbol(), count);
                }
                for (int k = 0; k < plantSize; k++) {
                    cellMap.put(island.getIsland().get(i).get(j).getPlants().get(k).getSymbol(), plantSize);
                }
                System.out.println(cellMap);
            }
        }
        System.out.println("<------------------------------Next Generation----------------------------->");
    }
}
