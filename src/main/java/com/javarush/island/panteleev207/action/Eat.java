package com.javarush.island.panteleev207.action;

import com.javarush.island.panteleev207.info.LimitAnimal;
import com.javarush.island.panteleev207.Location.Locate;
import com.javarush.island.panteleev207.RandomIsland;
import com.javarush.island.panteleev207.info.Statistic;
import com.javarush.island.panteleev207.organic.Animal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Eat implements Runnable {
    private final Locate locate;
    private Animal animalAt;
    private Animal animalDef;
    private LimitAnimal limitAnimal;
    private final Statistic statistic = new Statistic();
    private final RandomIsland randomIsland = new RandomIsland();

    public Eat(Locate locate) {
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
                    Iterator<Animal> iterator = animals.iterator();
                    while (iterator.hasNext()) {
                        Animal animal = iterator.next();
                        if (animal != null) {
                            animalAt = animal;
                            Class<?> animalAnnotationAt = animalAt.getClass();
                            limitAnimal = animalAnnotationAt.getAnnotation(LimitAnimal.class);
                            int numberAt = limitAnimal.number() - 1;
                            while (iterator.hasNext()) {
                                Animal animal1 = iterator.next();
                                if (!animalAt.equals(animal1)) {
                                    animalDef = animal1;
                                    Class<?> animalAnnotationDef = animalDef.getClass();
                                    limitAnimal = animalAnnotationDef.getAnnotation(LimitAnimal.class);
                                    int numberDef = limitAnimal.number() - 1;
                                    int chance = statistic.getEatRating()[numberAt][numberDef];
                                    int rndInt = randomIsland.getRandomCharacteristicInt(100);
                                    if (rndInt==0){
                                        continue;
                                    }
                                    if (rndInt <= chance) {
                                        iterator.remove();
                                        System.out.println("Съели " + animal1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}