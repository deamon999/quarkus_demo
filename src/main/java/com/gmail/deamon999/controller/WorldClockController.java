package com.gmail.deamon999.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gmail.deamon999.dto.WorldClock;
import com.gmail.deamon999.rest.WorldClockService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/now")
public class WorldClockController {

    @RestClient
    WorldClockService worldClockService;

    @GET
    @Path("{timezone}/mp")
    @Produces(MediaType.APPLICATION_JSON)
    public WorldClock getCurrentTimeMp(@PathParam("timezone") String timezone) {
        return worldClockService.getNow(timezone);
    }
}
