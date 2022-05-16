package com.gmail.deamon999.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gmail.deamon999.dto.WorldClock;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api")
@ApplicationScoped
@RegisterRestClient
public interface WorldClockService {
    @GET
    @Path("/json/{timezone}/now")
    @Produces(MediaType.APPLICATION_JSON)
    WorldClock getNow(@PathParam("timezone") String timezone);
}
