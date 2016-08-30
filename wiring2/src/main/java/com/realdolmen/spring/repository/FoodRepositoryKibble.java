package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.KibbleFood;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cda5732 on 13/04/2015.
 */
@Component
@Qualifier ("Kibble")
public class FoodRepositoryKibble implements FoodRepository {
    private Map<String, Food> feed = new HashMap<>();

    @Override
    public void addFoodForAnimalType(Class<? extends Animal> c, Food food) {
        // NOP
    }

    @Override
    public Food findFoodForAnimalType(Class<? extends Animal> c)
    {
        return new KibbleFood();
    }
}
