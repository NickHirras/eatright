package com.eatrightapp.service.api.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eatrightapp.service.api.converter.DishConverter;
import com.eatrightapp.service.api.converter.RestaurantInfoConverter;
import com.eatrightapp.service.api.model.DAO;
import com.eatrightapp.service.api.model.Dish;
import com.eatrightapp.service.api.model.RestaurantInfo;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.NotFoundException;
import com.googlecode.objectify.Objectify;

@Path("/dishes/")
public class DishService {
	Logger logger = Logger.getLogger(getClass().getName());

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<DishConverter> getRestaurant(@QueryParam("id") String id, @QueryParam("franchise") boolean franchise) {
		try {
			DAO dao = new DAO();
			Objectify ofy = dao.ofy();
			if(franchise) {
				return DishConverter.wrap(ofy.query(Dish.class).filter("franchiseId", id).list());
			} else {
				return DishConverter.wrap(ofy.query(Dish.class).filter("restaurantId", id).list());
			}
		} catch (NotFoundException nfe) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		
//		Dish dish = new Dish(null, "hooters-restaurant-pensacola", "hooters-restaurant", "Chef Salad", "Their chef salad is awesome, order it without bacon to save some calories.", null, null, false, null, null, 600, 15, 9, 3);
//		DAO dao = new DAO();
//		dao.ofy().put(dish);
//		return null;
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/update")
	public RestaurantInfoConverter updateFranchiseInfo(
			@FormParam("id") String id,
			@FormParam("franchise") boolean franchise,
			@FormParam("franchiseId") String franchiseId) {
		logger.info("entering updateFranchiseInfo()");
		logger.info("id=" + id + ", franchise=" + franchise + ", franchiseId=" + franchiseId);
		if(id == null || id.trim().length() < 1) {
			logger.info("throwing exception for invalid or missing id");
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		
		// Pull restaurant info if it already exists.
		RestaurantInfo restInfo = null;
		try {
			logger.info("attempting to retrieve existing restaurant");
			DAO dao = new DAO();
			restInfo = dao.ofy().get(new Key<RestaurantInfo>(RestaurantInfo.class, id));
			logger.info("We got something!");
		} catch (NotFoundException nfe) {
			logger.info("No data found, establishing new record");
			restInfo = new RestaurantInfo(id, franchise, null, false);
		}

		// Update the boolean and franchise-id appropriately.
		restInfo.setFranchise(franchise);
		if (franchise) {
			restInfo.setFranchiseId(franchiseId);
		} else {
			restInfo.setFranchiseId(null);
		}

		// Not try and persist it.
		try {
			logger.info("Trying to persist it.");
			DAO dao = new DAO();
			dao.ofy().put(restInfo);
			logger.info("Success!");
		} catch (Exception ex) {
			logger.info("FAIL!");
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Return the new object to the caller.
		RestaurantInfoConverter converter = new RestaurantInfoConverter(restInfo);
		logger.info("Returning " + restInfo.toString());
		return converter;
	}
}
