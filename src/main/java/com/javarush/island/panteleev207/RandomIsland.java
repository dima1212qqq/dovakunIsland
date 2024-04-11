package com.javarush.island.panteleev207;

import java.util.Random;

public class RandomIsland {
    public int getRandomForLocate(){
        return new Random().nextInt(100);
    }
    public int getRandomForChoice(){
        return new Random().nextInt(3);
    }
    public int getRandomCharacteristicInt(int n){
        return new Random().nextInt(n);
    }
    public double getRandomCharacteristicDouble(double n){
        return new Random().nextDouble(n);
    }
    public int getRandomMove(){
        return new Random().nextInt(4);
    }
}
