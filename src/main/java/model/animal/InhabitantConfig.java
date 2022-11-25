package model.animal;

import model.animal.herbivore.*;
import model.animal.raptor.*;
import model.plant.Grass;
import reader.PropertiesReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Inhabitant configuration data
 **/
public class InhabitantConfig {
    public static final List<Class<? extends Inhabitant>> inhabitantClassList = List.of(Boar.class,
            Buffalo.class, Caterpillar.class
            , Deer.class, Duck.class, Goat.class, Horse.class, Mouse.class, Rabbit.class
            , Sheep.class, Bear.class, Eagle.class, Fox.class, Snake.class, Wolf.class, Grass.class);
    /**
     * Map Key -> Hunter class, value it`s Map key-> Victim class, value eatProbability
     **/
    public static Map<Class<? extends Inhabitant>, Map<Class<? extends Inhabitant>, Integer>> fightProbabilityMap =
            new HashMap<>();
    /**
     * Map with inhabitant class and inhabitant max number on Cell
     **/
    public static final Map<Class<? extends Inhabitant>, Integer> maxNumberOnCellMap =
            new HashMap<>();

    static {
        fillFightProbability();
        fillMaxNumberOnCellMap();
    }

    private static void fillFightProbability() {
        for (Class<? extends Inhabitant> inhabitantClass : inhabitantClassList) {
            fightProbabilityMap.put(inhabitantClass, getInhabitantConfig(inhabitantClass));
        }
    }

    private static void fillMaxNumberOnCellMap() {
        PropertiesReader reader = new PropertiesReader("huntprobability");
        for (Class<? extends Inhabitant> inhabitantClass : inhabitantClassList) {
            Properties maxNumberOnCellProps = reader.loadProperties(inhabitantClass.getSimpleName().toLowerCase());
            Integer maxNumberOnCell = Integer.valueOf(maxNumberOnCellProps.getProperty("numberOnCell"));
            maxNumberOnCellMap.put(inhabitantClass, maxNumberOnCell);
        }
    }

    private static Map<Class<? extends Inhabitant>, Integer> getInhabitantConfig(Class<? extends Inhabitant> hunterClass) {
        Map<Class<? extends Inhabitant>, Integer> victimMap = new HashMap<>();
        String hunter = hunterClass.getSimpleName().toLowerCase();
        PropertiesReader reader = new PropertiesReader("huntprobability");
        Properties victimProbability = reader.loadProperties(hunter);
        for (Class<? extends Inhabitant> victimClass : inhabitantClassList) {
            String name = victimClass.getSimpleName();
            Integer probability = Integer.valueOf(victimProbability.getProperty(name.toLowerCase()));
            victimMap.put(victimClass, probability);
        }
        return victimMap;
    }
}
