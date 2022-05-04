package com.gmail.deamon999.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.gmail.deamon999.model.Developer;
import org.jboss.logging.Logger;

@Path("/developer")
public class DeveloperResource {

    private static final Logger logger = Logger.getLogger(DeveloperResource.class);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        logger.info("Create developer method started");
        developer.persist();
        return Response.created(
                        UriBuilder
                                .fromResource(DeveloperResource.class)
                                .path(Long.toString(developer.getId()))
                                .build()
                )
                .entity(developer)
                .build();
    }
}
