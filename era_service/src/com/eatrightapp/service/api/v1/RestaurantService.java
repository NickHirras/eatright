package com.eatrightapp.service.api.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.eatrightapp.service.data.v1.DAO;
import com.eatrightapp.service.data.v1.ERAError;
import com.eatrightapp.service.data.v1.Restaurant;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.NotFoundException;

@Path("/restaurant/{id}")
public class RestaurantService {
	
	// Please see http://zhoupengylx.blogspot.com/2010/06/restful-on-google-app-engine-in-5.html
	
	@GET
	@Produces("text/plain")
	public String getRestaurant(@PathParam("id") String id) {

		DAO dao = new DAO();
	
		if(id == null || id.trim().length() == 0) {
			ERAError err = new ERAError("MISSING_REQUIRED_PARAMETER", "id", "You must specify a valid restaurant ID on the path, such as /restaurant/hooters-restaurant-gulf-breeze/");
			Restaurant rest = new Restaurant();
			rest.setError(err);
			return dao.gson().toJson(rest);
		}

		try {
			Restaurant rest = dao.ofy().get(new Key<Restaurant>(Restaurant.class, id));
			return dao.gson().toJson(rest);
		} catch(NotFoundException nfe) {
			return "";
		}
	}
}
