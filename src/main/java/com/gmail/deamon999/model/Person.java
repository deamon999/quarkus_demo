package com.gmail.deamon999.model;

import java.util.List;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Person extends PanacheEntity {

    //accessors must be public when extending from base class
    @NotBlank
    public String name;
    @NotNull
    public Status status;

    public static Person findByName(String name) {
        return find("name", name).firstResult();
    }

    public static List<Person> find(Status status) {
        return list("status", status);
    }

    public static void delete(String name) {
        delete("name", name);
    }
}
