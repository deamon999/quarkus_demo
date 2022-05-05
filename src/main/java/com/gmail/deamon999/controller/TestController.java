package com.gmail.deamon999.controller;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gmail.deamon999.model.Order;
import com.gmail.deamon999.service.GreetingService;
import org.eclipse.microprofile.config.Config;
import org.jboss.logging.Logger;


@Path("/test")
public class TestController {

    private static final Logger logger = Logger.getLogger(TestController.class);

    //The Eclipse MicroProfile Configuration spec allows you to inject org.eclipse.micro
    //profile.config.Config to get properties programmatically instead of injecting
    //directly with ConfigProperty.
    @Inject
    Config config;
    @Inject
    GreetingService greetingService;

    @GET
    @Path("/greeting")
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting(@QueryParam("age") int age) {
        logger.info("Greeting method started");
        return greetingService.greetingMessage(age);
    }


    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConfig() {
        logger.info("Config method started");
        return StreamSupport.stream(config.getPropertyNames().spliterator(), false).collect(Collectors.joining(System.lineSeparator()));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context UriInfo uriInfo, @QueryParam("order") Order order, @NotBlank @HeaderParam("authorization") String authorization) {
        return String.format("URI: %s - Order %s - Authorization: %s", uriInfo.getAbsolutePath(), order, authorization);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String create(String message) {
        logger.info("Create method: " + message);
        return message;
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(String message) {
        logger.info("Update method: " + message);
        return message;
    }

    @DELETE
    public void delete() {
        logger.info("Delete method");
    }
}
