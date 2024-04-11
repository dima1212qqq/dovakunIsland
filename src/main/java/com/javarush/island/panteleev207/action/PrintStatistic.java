package com.javarush.island.panteleev207.action;

import com.javarush.island.panteleev207.Location.Locate;
import com.javarush.island.panteleev207.organic.Animal;
import com.javarush.island.panteleev207.organic.predators.Bear;
import com.javarush.island.panteleev207.organic.herbivore.Mouse;

import java.util.List;

public class PrintStatistic implements Runnable {
    private final Locate locate;
    private int counterBear;
    private int counterMouse;

    public PrintStatistic(Locate locate) {
        this.locate = locate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                List<Animal> animals = locate.getCages()[i][j].getAnimals();
                for (Animal animal : animals) {
                    if (animal instanceof Bear) {
                        counterBear++;
                    } else if (animal instanceof Mouse) {
                        counterMouse++;
                    }
                }
            }
        }
        System.out.println(counterBear);
        System.out.println(counterMouse);
        counterMouse = 0;
        counterBear=0;
    }
}