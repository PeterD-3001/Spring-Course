package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.Bear;
import com.realdolmen.spring.domain.Elephant;
import com.realdolmen.spring.domain.Tiger;
import com.realdolmen.spring.service.PlankenDaal;
import com.realdolmen.spring.service.Zoo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cerseilannister on 26/08/16.
 */
@Configuration
public class ZooConfig {
  @Bean
  public Zoo f() {
      PlankenDaal myPlankenDaal = new PlankenDaal("PlankenDaal-1");
      myPlankenDaal.addAnimal(new Bear("Baloe"));
      myPlankenDaal.addAnimal(new Bear("Poo"));
      myPlankenDaal.addAnimal(new Tiger("Sheherakan"));
      myPlankenDaal.addAnimal(new Elephant("Dumbo"));
      return myPlankenDaal;
  }

}
