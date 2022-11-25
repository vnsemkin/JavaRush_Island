package model.Island;

import java.util.ArrayList;
import java.util.List;

public class Island {
    private List<List<Cell>> island;
    private final int x = IslandConfig.getIslandSizeByX();
    private final int y = IslandConfig.getIslandSizeByY();

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
