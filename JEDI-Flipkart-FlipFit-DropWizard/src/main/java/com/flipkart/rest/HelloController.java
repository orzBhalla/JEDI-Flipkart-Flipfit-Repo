package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController {

    @GET
    public String getEmployees() {
        return "my dropwizard service";
    }

}