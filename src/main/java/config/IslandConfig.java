package config;

import util.PropertiesReader;

import java.util.Properties;

/**
 * Island configuration data
 **/

public class IslandConfig {
    private final Properties island;

    {
        island = PropertiesReader.loadProperties(IslandConstants.ISLAND_PROPS_NAME
                ,IslandConstants.ISLAND_PROPS_FOLDER);
    }

    public int getIslandSizeByX() {
        return Integer.parseInt(island.getProperty(IslandConstants.X));
    }

    public int getIslandSizeByY() {
        return Integer.parseInt(island.getProperty(IslandConstants.Y));
    }
}
