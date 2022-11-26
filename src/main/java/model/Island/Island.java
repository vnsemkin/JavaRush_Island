package model.Island;

import java.util.ArrayList;
import java.util.List;

public class Island {
    private final List<List<Cell>> island;
    private final IslandConfig islandConfig = new IslandConfig();
    private final int x = islandConfig.getIslandSizeByX();
    private final int y = islandConfig.getIslandSizeByY();

    public Island() {
        island = new ArrayList<>(x);
        for (int i = 0; i < x; i++) {
            island.add(new ArrayList<>(y));
        }
    }

    public List<List<Cell>> getIsland() {
        return island;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
