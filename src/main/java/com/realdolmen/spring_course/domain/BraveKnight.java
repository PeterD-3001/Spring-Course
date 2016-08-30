package com.realdolmen.spring_course.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BraveKnight implements Knight {
    @Autowired
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        System.out.println("KNIGHT: I'm a KNIGHT and I am brave");
        String message = quest.embark("Smaug");
        System.out.println(message);
    }
}
