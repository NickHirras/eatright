package com.eatrightapp.service.api.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eatrightapp.service.api.converter.DishConverter;
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
			List<DishConverter> results;
			if(franchise) {
				results = DishConverter.wrap(ofy.query(Dish.class).filter("franchiseId", id).list());
			} else {
				results = DishConverter.wrap(ofy.query(Dish.class).filter("restaurantId", id).list());
			}
			if(results != null && results.size() > 0) {
				results.add(new DishConverter());
			}
			return results;
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
	@Path("/rate")
	public DishConverter rate(@FormParam("dishId") long dishId, @FormParam("recommended") boolean recommended)
	{
		try {
			DAO dao = new DAO();

			// Pull the requested record.
			Dish dish = dao.ofy().get(new Key<Dish>(Dish.class, dishId));
			
			// Update the likes/dislikes.
			if(recommended) {
				dish.setLikes(dish.getLikes() + 1);
			} else {
				dish.setDislikes(dish.getDislikes() + 1);
			}
			
			// Write it back out.
			dao.ofy().put(dish);
			
			// Return it to the user if they wish to have it.
			return new DishConverter(dish);
		} catch (NotFoundException nfe) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		
	}

//	@POST
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Path("/update")
//	public RestaurantInfoConverter updateFranchiseInfo(
//			@FormParam("id") String id,
//			@FormParam("franchise") boolean franchise,
//			@FormParam("franchiseId") String franchiseId) {
//		logger.info("entering updateFranchiseInfo()");
//		logger.info("id=" + id + ", franchise=" + franchise + ", franchiseId=" + franchiseId);
//		if(id == null || id.trim().length() < 1) {
//			logger.info("throwing exception for invalid or missing id");
//			throw new WebApplicationException(Response.Status.BAD_REQUEST);
//		}
//		
//		// Pull restaurant info if it already exists.
//		RestaurantInfo restInfo = null;
//		try {
//			logger.info("attempting to retrieve existing restaurant");
//			DAO dao = new DAO();
//			restInfo = dao.ofy().get(new Key<RestaurantInfo>(RestaurantInfo.class, id));
//			logger.info("We got something!");
//		} catch (NotFoundException nfe) {
//			logger.info("No data found, establishing new record");
//			restInfo = new RestaurantInfo(id, franchise, null, false);
//		}
//
//		// Update the boolean and franchise-id appropriately.
//		restInfo.setFranchise(franchise);
//		if (franchise) {
//			restInfo.setFranchiseId(franchiseId);
//		} else {
//			restInfo.setFranchiseId(null);
//		}
//
//		// Not try and persist it.
//		try {
//			logger.info("Trying to persist it.");
//			DAO dao = new DAO();
//			dao.ofy().put(restInfo);
//			logger.info("Success!");
//		} catch (Exception ex) {
//			logger.info("FAIL!");
//			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
//		}
//
//		// Return the new object to the caller.
//		RestaurantInfoConverter converter = new RestaurantInfoConverter(restInfo);
//		logger.info("Returning " + restInfo.toString());
//		return converter;
//	}
	
	@PUT
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/create")
	public DishConverter createDish(
			@FormParam("restaurantId") String restaurantId,
			@FormParam("franchiseId") String franchiseId,
			@FormParam("title") String title,
			@FormParam("description") String description,
			@FormParam("calories") int calories,
			@FormParam("protein") int protein,
			@FormParam("fat") int fat,
			@FormParam("carbs") int carbs){

		if( (restaurantId == null || restaurantId.trim().length() < 1) && (franchiseId == null || franchiseId.trim().length() < 1) ) {
			logger.info("throwing exception for invalid or missing id");
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		
		// Pull restaurant info if it already exists.
		RestaurantInfo restInfo = null;
		Dish dish = new Dish(null, restaurantId, franchiseId, title, description, null, null, false, null, null, calories, protein, fat, carbs, 0, 0);

		// Not try and persist it.
		try {
			DAO dao = new DAO();
			dao.ofy().put(dish);
		} catch (Exception ex) {
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}

		// Return the new object to the caller.
		DishConverter converter = new DishConverter(dish);
		return converter;
	}

}
