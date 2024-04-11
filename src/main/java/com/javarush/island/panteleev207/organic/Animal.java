package com.javarush.island.panteleev207.organic;

public abstract class Animal{
    private double weight;
    private int speed;
    private double eat;


    public Animal(double weight, int maxSpeed, double normalEat){
        this.weight = weight;
        this.speed = maxSpeed;
        this.eat = normalEat;

    }

}