package com.kwc.testen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@Path("/favicon.ico")
public final class FavIcoService {

    @GET
    public Response favicon() {
        return Response.ok().header("Content-length", 0).build();
    }

}
