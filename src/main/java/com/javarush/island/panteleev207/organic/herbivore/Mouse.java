package com.javarush.island.panteleev207.organic.herbivore;

import com.javarush.island.panteleev207.info.LimitAnimal;
import com.javarush.island.panteleev207.organic.Herbivore;

@LimitAnimal(maxWeight = 0.05,maxCounterInCage = 500,maxSpeed = 2,normalEat = 0.01, number = 2)
public class Mouse extends Herbivore {
    public Mouse(double weight,  int maxSpeed, double normalEat) {
        super(weight, maxSpeed, normalEat);
    }
}