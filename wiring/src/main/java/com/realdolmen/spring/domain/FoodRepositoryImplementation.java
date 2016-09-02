package com.realdolmen.spring.domain;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by cerseilannister on 26/08/16.
 */
@Component
public class FoodRepositoryImplementation implements FoodRepository {

    private Map<Class<? extends Animal>,Food> tabel;

    public void addFoodForAnimalType(Class<? extends Animal> clazz,Food food)
    {
      tabel.put(clazz,food);
    }

    public Food findFoodForAnimalType(Class<? extends Animal> clazz)
    {
      return tabel.get(clazz.getClass());
    }

}
