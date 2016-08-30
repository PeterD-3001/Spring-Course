package com.realdolmen.spring.domain;

/**
 * Created by cerseilannister on 26/08/16.
 */
public interface FoodRepository {
    void addFoodForAnimalType(Class<? extends Animal> clazz,Food food);
    Food findFoodForAnimalType(Class<? extends Animal> clazz);
}
