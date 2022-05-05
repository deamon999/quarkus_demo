package com.gmail.deamon999.model;

import java.util.Random;
import javax.validation.constraints.NotBlank;

public class Developer {
    private long id;
    @NotBlank
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
