package com.javarush.island.panteleev207.action;

import com.javarush.island.panteleev207.GenerateAnimal;
import com.javarush.island.panteleev207.Location.Locate;
import com.javarush.island.panteleev207.RandomIsland;
import com.javarush.island.panteleev207.info.LimitAnimal;
import com.javarush.island.panteleev207.organic.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Reproduction implements Runnable {
    private final GenerateAnimal generateAnimal = new GenerateAnimal();
    private final Locate locate;
    private final RandomIsland randomIsland = new RandomIsland();

    public Reproduction(Locate locate) {
        this.locate = locate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                List<Animal> animals;
                synchronized (locate.getCages()[i][j]) {
                    animals = new ArrayList<>(locate.getCages()[i][j].getAnimals());
                }
                synchronized (animals) {
                    ListIterator<Animal> iterator = animals.listIterator();
                    while (iterator.hasNext()) {
                        Animal animal = iterator.next();
                        if (animal != null) {
                            while (iterator.hasNext()) {
                                Animal animal1 = iterator.next();
                                if (animal.getClass() == animal1.getClass()) {
                                    int n = randomIsland.getRandomCharacteristicInt(100);
                                    if (n <= 25) {
                                        locate.getCages()[i][j].addAnimal(generateNewAnimal(animal.getClass()));
                                        System.out.println("Родился " + animal);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Animal generateNewAnimal(Class<? extends Animal> animalClass) {
        LimitAnimal limitAnimal = animalClass.getAnnotation(LimitAnimal.class);
        double maxWeight = limitAnimal.maxWeight();
        int maxSpeed = limitAnimal.maxSpeed();
        double weight = randomIsland.getRandomCharacteristicDouble(maxWeight);
        int speed = randomIsland.getRandomCharacteristicInt(maxSpeed);
        return instantiateAnimal(animalClass, weight, speed);
    }

    private Animal instantiateAnimal(Class<? extends Animal> animalClass, double weight, int speed) {
        try {
            return animalClass.getDeclaredConstructor(double.class, int.class, double.class).newInstance(weight, speed, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}