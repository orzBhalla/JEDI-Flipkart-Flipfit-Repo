package com.flipkart.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/check")
@Produces(MediaType.APPLICATION_JSON)
public class DemoController {

    @GET
    public String isServerUp() {
        return "Server is up!";
    }

}