package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.FoodDistributionService;
import com.realdolmen.spring.domain.FoodRepository;
import com.realdolmen.spring.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cda5732 on 25/03/2015.
 */
public class PairiDaiza implements Zoo {
    private String name;
    private List<Animal> animals = new ArrayList<>();

    @Autowired
    private FoodDistributionService fds;
    // TODO fetch the FoodDistributionService
    // private FoodRepository fdr;

    public PairiDaiza(String name) {
        this.name = name;
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void releaseAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public boolean accept(Visitor visitor) {
        System.out.println("Welcome visitor to " + getName());
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }


    // TODO Call the FoodDistributionService to feed animals
    @Override
    public void feedAnimals(){
        fds.feedAnimalsByType(animals);

    };


}
