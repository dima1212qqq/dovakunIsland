package com.javarush.island.panteleev207;


import com.javarush.island.panteleev207.info.LimitAnimal;
import com.javarush.island.panteleev207.organic.Animal;
import com.javarush.island.panteleev207.organic.predators.Bear;
import com.javarush.island.panteleev207.organic.herbivore.Mouse;

public class GenerateAnimal {
    private final RandomIsland randomIsland;
    private LimitAnimal limitAnimal;
    private int result;
    private Class animal;

    public GenerateAnimal() {
        randomIsland = new RandomIsland();
    }

    public Animal generateAnimal() {
        result = randomIsland.getRandomForChoice();

        switch (result) {
            case 0:
                animal = Bear.class;
                limitAnimal = (LimitAnimal) animal.getAnnotation(LimitAnimal.class);
                return new Bear(randomIsland.getRandomCharacteristicDouble(limitAnimal.maxWeight()), randomIsland.getRandomCharacteristicInt(limitAnimal.maxSpeed()), 0);
            case 1:
                animal = Mouse.class;
                limitAnimal = (LimitAnimal) animal.getAnnotation(LimitAnimal.class);
                return new Mouse(randomIsland.getRandomCharacteristicDouble(limitAnimal.maxWeight()), randomIsland.getRandomCharacteristicInt(limitAnimal.maxSpeed()), 0);
            default:
                return null;
        }
    }

    public Animal generateNewAnimal(Class<? extends Animal> animalClass) {
        limitAnimal = animalClass.getAnnotation(LimitAnimal.class);
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