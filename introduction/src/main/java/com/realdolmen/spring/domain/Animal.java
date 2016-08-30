package com.realdolmen.spring.domain;

/**
 * Created by cerseilannister on 26/08/16.
 */
public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
