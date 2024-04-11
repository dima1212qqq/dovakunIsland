package com.javarush.island.panteleev207;

import com.javarush.island.panteleev207.Location.Cage;
import com.javarush.island.panteleev207.Location.GeneratorLocate;
import com.javarush.island.panteleev207.Location.Locate;
import com.javarush.island.panteleev207.action.Eat;
import com.javarush.island.panteleev207.action.Move;
import com.javarush.island.panteleev207.action.PrintStatistic;
import com.javarush.island.panteleev207.action.Reproduction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Locate locate = new Locate(10, 10);
        GeneratorLocate generatorLocate = new GeneratorLocate();
        generatorLocate.generateLocate(locate);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Move move = new Move(locate, 10, 10);
        Eat eat = new Eat(locate);
        Reproduction reproduction = new Reproduction(locate);
        PrintStatistic printStatistic = new PrintStatistic(locate);
        while (true) {
            pool.execute(move);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.execute(eat);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.execute(reproduction);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.execute(printStatistic);

        }
    }
}