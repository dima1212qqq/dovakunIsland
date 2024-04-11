package com.javarush.island.panteleev207.Location;

import com.javarush.island.panteleev207.GenerateAnimal;
import com.javarush.island.panteleev207.Location.Cage;
import com.javarush.island.panteleev207.Location.Locate;
import com.javarush.island.panteleev207.organic.Animal;

public class GeneratorLocate {
    private final GenerateAnimal generateAnimal = new GenerateAnimal();
    public Locate generateLocate(Locate locate){
        for (int i = 0; i < locate.getCages().length; i++) {
            for (int j = 0; j < locate.getCages()[i].length; j++) {
                Animal animal = generateAnimal.generateAnimal();
                if(animal == null){
                    continue;
                }
                locate.getCages()[i][j].addAnimal(animal);
            }
        }
        return locate;
    }
}