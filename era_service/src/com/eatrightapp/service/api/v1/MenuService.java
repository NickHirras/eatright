package com.eatrightapp.service.api.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/menu")
public class MenuService {
    @GET
    @Produces("text/plain")
    public String getItems() {
        return "return menu for specified restaurant.";
    }
}
