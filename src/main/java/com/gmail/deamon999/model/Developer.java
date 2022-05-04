package com.gmail.deamon999.model;

import java.util.Random;

public class Developer {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void persist() {
        this.id = new Random().nextLong();
    }
}
