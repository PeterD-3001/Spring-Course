package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerseilannister on 26/08/16.
 */

public class PlankenDaal implements Zoo{
    private String name;
    private List<Animal> plankenDaalLijst = new ArrayList<>();

    public PlankenDaal(String name) {
        this.name = name;
    }

    @Override
    public void addAnimal(Animal animal) {
        plankenDaalLijst.add(animal);
    }

    @Override
    public void releaseAnimal(Animal animal) {
        plankenDaalLijst.remove(animal);

    }

    @Override
    public boolean accept(Visitor visitor) {
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int countAnimals() {
        return plankenDaalLijst.size();
    }
}
