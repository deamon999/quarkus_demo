package com.gmail.deamon999.reactive_controller;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.RoutingContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TestReactiveController {

    private static final Logger logger = Logger.getLogger(TestReactiveController.class);

    @ConfigProperty(name = "demo.string")
    String str;
    @ConfigProperty(name = "demo.upper-case", defaultValue = "true")
    boolean upperCase;

    //declarative approach
    @Route(path = "/declarativeok", methods = Route.HttpMethod.GET)
    public void greetings(RoutingContext routingContext) {
        logger.info("reactive declarative method started");
        String name = routingContext.request().getParam("name");
        if (name == null) {
            name = upperCase ? str.toUpperCase() : str;
        }
        routingContext.response().end("OK " + name + " you are right");
    }
}
