package model.Island;

import reader.PropertiesReader;

import java.util.Properties;

/**
 * Island configuration data
 **/
public class IslandConfig {
    static PropertiesReader reader = new PropertiesReader("islandproperties");
    static Properties island;

    static {
        island = reader.loadProperties("island");
    }

    public static int getIslandSizeByX() {
        return Integer.parseInt(island.getProperty("x"));
    }

    public static int getIslandSizeByY() {
        return Integer.parseInt(island.getProperty("y"));
    }
}
