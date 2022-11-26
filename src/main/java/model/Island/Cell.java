package model.Island;

import model.animal.Animal;
import model.plant.Plant;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Plant> plants = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}
