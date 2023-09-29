package model.Island;

import lombok.Getter;
import model.animal.Animal;
import model.plant.Plant;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cell {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();
}
