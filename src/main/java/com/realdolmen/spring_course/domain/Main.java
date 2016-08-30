package com.realdolmen.spring_course.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by cerseilannister on 26/08/16.
 */
@SpringBootApplication

public class Main {

    public static void main(String[] args) {

        // Spring start hierdoor zijn application context op...
        //... naar analogie met Tomcat-Catalina
        ApplicationContext context = SpringApplication.run(Main.class);

        Knight k = context.getBean(Knight.class);
        System.out.println(k);
        k.embarkOnQuest();
    }
}
