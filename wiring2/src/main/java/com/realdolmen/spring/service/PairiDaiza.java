package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cda5732 on 25/03/2015.
 */
public class PairiDaiza implements Zoo {

    // DONE Add maxAnimalCount, ownerName and ticketPrice, and load from properties
    @Value("${zoo.name}")
    private String name;

    // nieuwe properties toe te voegen
    @Value("${zoo.maxAnimalCount}")
    private int maxAnimalCount;

    @Value("${zoo.ownerName}")
    private String ownerName;

    @Value("${zoo.ticketPrice}")
    private int ticketPrice;

    private List<Animal> animals = new ArrayList<>();

    @Autowired
    private FoodDistributionService foodDistributionService;

    public PairiDaiza() {

    }

    // ====== Property injection voor de naam van de zoo =========================
    public PairiDaiza( String name) {
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
    public String getName() {
        return name;
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }

    @Override
    public void feedAnimals() {
        foodDistributionService.feedAnimalsByType(animals);
    }

    @Override
    public boolean accept(Visitor visitor) {
        System.out.println("Welcome visitor to " + getName());
        return false;
    }

    // Getters en Setters voor nieuwe properties
    @Override
    public int getMaxAnimalCount() {
        return maxAnimalCount;
    }

    public void setMaxAnimalCount(int maxAnimalCount) {
        this.maxAnimalCount = maxAnimalCount;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
