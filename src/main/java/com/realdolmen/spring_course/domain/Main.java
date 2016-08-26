package com.realdolmen.spring_course.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by cerseilannister on 26/08/16.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        // Spring start hierdoor zijn application context op...
        //... naar analogie met Tomcat-Catalina
        ApplicationContext ac = SpringApplication.run(MyConfiguration.class);

        Knight k = ac.getBean(Knight.class);
        k.embarkOnQuest();
    }
}
