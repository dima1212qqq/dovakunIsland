package com.javarush.island.panteleev207.Location;

import com.javarush.island.panteleev207.organic.Animal;
import com.javarush.island.panteleev207.organic.Grass;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private final List<Animal> animals;

    private Grass grass;
    public Cage() {
        animals = new ArrayList<>();

    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
    public List<Animal> getAnimals() {
        return animals;
    }
}