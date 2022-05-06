package com.gmail.deamon999.repository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import com.gmail.deamon999.model.Developer;
import com.gmail.deamon999.model.Status;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DeveloperRepository implements PanacheRepository<Developer> {

    // put your custom logic here as instance methods

    public Developer findByName(String name) {
        return find("name", name).firstResult();
    }

    public List<Developer> find(Status status) {
        return list("status", status);
    }

    public void delete(String name) {
        delete("name", name);
    }
}
