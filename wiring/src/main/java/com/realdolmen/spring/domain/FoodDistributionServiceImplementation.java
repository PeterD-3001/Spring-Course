package com.realdolmen.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cerseilannister on 26/08/16.
 */
@Component
public class FoodDistributionServiceImplementation implements FoodDistributionService {

    @Autowired
    private FoodRepository fdr;

    public void feedAnimalsByType(List<Animal> animals)
    {
      for (Animal a :animals)
      {

          Food eten = fdr.findFoodForAnimalType (a.getClass());
          System.out.println("Feeding food: "+eten+" to animal: "+a);

    }
    }
}
