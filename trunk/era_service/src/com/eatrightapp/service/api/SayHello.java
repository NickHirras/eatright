package com.eatrightapp.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloworld")
public class SayHello {
    @GET
    @Produces("text/plain")
    public String getItems() {
        return "restful web service example";
    }

}
