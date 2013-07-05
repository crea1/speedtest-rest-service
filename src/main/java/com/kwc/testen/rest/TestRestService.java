package com.kwc.testen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author Marius Kristensen
 */
@Path("/")
public class TestRestService {

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {
        String response = "Tada: " + msg;
        return Response.status(Response.Status.OK).entity(response).build();
    }

}
