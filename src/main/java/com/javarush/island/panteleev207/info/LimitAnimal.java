package com.javarush.island.panteleev207.info;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface LimitAnimal {
    double maxWeight();
    int maxCounterInCage();
    int maxSpeed();
    double normalEat();
    int number();
}