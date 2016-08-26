package com.realdolmen.spring_course.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cerseilannister on 26/08/16.
 */

@Configuration
// Deze annotation zorgt ervoor dat Spring weet dat hij iets moet doen
public class MyConfiguration {

    @Bean
    public Quest blaQuest(){
        return new SlayDragonQuest();
    }

    @Bean
    public Knight fooKnight(){
        return new BraveKnight(blaQuest());
    }

}
