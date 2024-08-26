package org.codecaveofandrew;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/cicd")
    @Produces(MediaType.TEXT_PLAIN)
    public String cicd() {
        return "Hello from CICD";
    }


    @GET
    @Path("/nice")
    @Produces(MediaType.TEXT_PLAIN)
    public String nice() {
        return "to meet you";
    }
}
