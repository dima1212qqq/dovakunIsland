package com.javarush.island.panteleev207.action;

import com.javarush.island.panteleev207.info.LimitAnimal;
import com.javarush.island.panteleev207.Location.Locate;
import com.javarush.island.panteleev207.RandomIsland;
import com.javarush.island.panteleev207.organic.Animal;

import java.util.Iterator;
import java.util.List;

public class Move implements Runnable {
    private final RandomIsland randomIsland = new RandomIsland();

    private LimitAnimal limitAnimal;
    private final Locate locate;
    private final int x;
    private final int y;

    public Move(Locate locate, int x, int y) {
        this.locate = locate;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                List<Animal> animals = locate.getCages()[i][j].getAnimals();
                synchronized (animals) {
                    Iterator<Animal> iterator = animals.iterator();
                    while (iterator.hasNext()) {
                        Animal animal = iterator.next();
                        if (animal != null) {
                            Class<?> animalClass = animal.getClass();
                            int n = randomIsland.getRandomMove();
                            limitAnimal = animalClass.getAnnotation(LimitAnimal.class);
                            int step = limitAnimal.maxSpeed();
                            int rndStep = randomIsland.getRandomCharacteristicInt(step);
                            switch (n) {
                                case 0:
                                    if (rndStep != 0) {
                                        if (j + rndStep >= 10) {
                                            locate.getCages()[i][j - rndStep].addAnimal(animal);
                                        } else {
                                            locate.getCages()[i][j + rndStep].addAnimal(animal);
                                        }
                                        iterator.remove();
                                    }
                                    break;
                                case 1:
                                    if (rndStep != 0) {
                                        if (i + rndStep >= 10) {
                                            locate.getCages()[i - rndStep][j].addAnimal(animal);
                                        } else {
                                            locate.getCages()[i + rndStep][j].addAnimal(animal);
                                        }
                                        iterator.remove();
                                    }
                                    break;
                                case 2:
                                    if (rndStep != 0) {
                                        if (j - rndStep >= 0) {
                                            locate.getCages()[i][j - rndStep].addAnimal(animal);
                                        } else {
                                            locate.getCages()[i][j + rndStep].addAnimal(animal);
                                        }
                                        iterator.remove();
                                    }
                                    break;
                                case 3:
                                    if (rndStep != 0) {
                                        if (i - rndStep >= 0) {
                                            locate.getCages()[i - rndStep][j].addAnimal(animal);
                                        } else {
                                            locate.getCages()[i + rndStep][j].addAnimal(animal);
                                        }
                                        iterator.remove();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
}