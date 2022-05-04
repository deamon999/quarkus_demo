package com.gmail.deamon999;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.vertx.http.runtime.filters.Filters;
import io.vertx.ext.web.Router;


@ApplicationScoped
public class ApplicationReactiveConfig {

    //Using Router instance
    public void routes(@Observes Router router) {
        router
                .get("/ok")
                .handler(rc -> rc.response().end("OK from Route"));
    }

    //It is important to note that these filters are applied for servlets, JAX-RS resources, and
    //reactive routes.
    public void filters(@Observes Filters filters) {
        filters
                .register(
                        rc -> {
                            rc.response()
                                    .putHeader("V-Header", "Header added by VertX Filter");
                            rc.next();
                        },
                        10);
    }
}
