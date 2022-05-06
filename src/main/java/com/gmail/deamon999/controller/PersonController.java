package com.gmail.deamon999.controller;

import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.gmail.deamon999.interceptor.LogEvent;
import com.gmail.deamon999.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.jboss.logging.Logger;

@Path("/person")
@Transactional
public class PersonController {
    private static final Logger logger = Logger.getLogger(PersonController.class);

    @LogEvent
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(@Valid Person person) {
        logger.info("Create person method started");
        person.persist();
        return Response.created(
                        UriBuilder
                                .fromResource(DeveloperController.class)
                                .path(Long.toString(person.id))
                                .build()
                )
                .entity(person)
                .build();
    }

    @LogEvent
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.NEVER)
    public Response getAllPersons() {
        logger.info("Get all persons method started");
        List<Person> list = Person.listAll();
        return Response.ok()
                .entity(list)
                .build();
    }
}
