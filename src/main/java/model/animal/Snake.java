package model.animal;

import config.AnimalConfig;

public class Snake extends Animal implements Raptor {
    private static final Animal snake;

    static {
        snake = AnimalConfig.getINSTANCE().getAnimalsProps().get("Snake");
    }

    public Snake() {
        super(snake.getName()
                , snake.getSymbol()
                , snake.getWeight()
                , snake.getCellsMove()
                , snake.getFoodSaturation());
    }
}
