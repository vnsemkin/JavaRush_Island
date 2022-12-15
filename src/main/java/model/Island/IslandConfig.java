package model.Island;

import reader.PropertiesReader;

import java.util.Properties;

/**
 * Island configuration data
 **/
public class IslandConfig {
    private final PropertiesReader reader = new PropertiesReader("islandprops");
    private final Properties island;

    {
        island = reader.loadProperties("island");
    }

    public int getIslandSizeByX() {
        return Integer.parseInt(island.getProperty("x"));
    }

    public int getIslandSizeByY() {
        return Integer.parseInt(island.getProperty("y"));
    }
}
