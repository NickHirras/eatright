package com.eatrightapp.service.v1.api;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
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
		Logger.getAnonymousLogger().fine("Entering RestaurantService.getRestaurant");

		DAO dao = new DAO();

		RestaurantDSO rest = dao.ofy().get(new Key<RestaurantDSO>(RestaurantDSO.class, id));
		return rest;
	
	}

	
//	@POST
//	@Path("update")
//	@Consumes("text/plain")
//	@Produces("text/plain")
//	public static String updateRestaurant(@Context Request request) {
//		DAO dao = new DAO();
//		Restaurant restaurant = dao.gson().fromJson(request., Restaurant.class);
//		return "You sent me restaurant " + restaurant.getId() + " with chain value of " + restaurant.isChain();
//	}
}
