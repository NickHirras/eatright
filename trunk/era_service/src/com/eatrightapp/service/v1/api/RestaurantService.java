package com.eatrightapp.service.v1.api;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.eatrightapp.service.v1.datastore.DAO;
import com.eatrightapp.service.v1.datastore.RestaurantDSO;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.NotFoundException;

@Path("/restaurants")
public class RestaurantService {
	
	// Please see http://zhoupengylx.blogspot.com/2010/06/restful-on-google-app-engine-in-5.html
	
	/**
	 * Retrieve extra information about a restaurant.  
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RestaurantDSO getRestaurant(@PathParam("id") String id) {
		DAO dao = new DAO();

		RestaurantDSO rest = dao.ofy().get(new Key<RestaurantDSO>(RestaurantDSO.class, id));
		return rest;
	
	}

	
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRestaurant(Restaurant restaurant) {
		System.err.println("RestaurantService.updateRestaurant");
		System.err.println("Restaurant = " + restaurant.getId());
		System.err.println("Chain = " + restaurant.isChain());
		return null;
	}
}
