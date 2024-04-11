package com.javarush.island.panteleev207.organic.predators;

import com.javarush.island.panteleev207.info.LimitAnimal;
import com.javarush.island.panteleev207.organic.Predator;


@LimitAnimal(maxWeight = 500,maxCounterInCage = 5,maxSpeed = 2,normalEat = 80, number = 1)
public class Bear extends Predator {
    public Bear(double weight, int speed, double eat) {
        super(weight, speed, eat);
    }


}