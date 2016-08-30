package com.realdolmen.spring_course.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Primary
public class SlayDragonQuest implements Quest {
    @Override
    public String embark(String who) {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Knights gets eaten by Dragon !");
        }
        else {
            System.out.println("QUEST: Knight slays dragon named "+who);
            return "RETURN: Beautiful Princess brings Dragon's Head and much more...";
        }
    }
}
