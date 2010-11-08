package com.eatrightapp.shared;

import java.util.List;

import com.eatrightapp.server.domain.Restaurant;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(Restaurant.class)
public interface RestaurantRequest extends RequestContext {
	Request<Long> countRestaurants();
	Request<List<RestaurantProxy>> findRestaurantsByName(String restaurantName, int firstResult, int maxResults);
	Request<List<RestaurantProxy>> findRestaurantsByUrl(String url, int firstResult, int maxResults);
	Request<List<RestaurantProxy>> findRestaurantsByLocation(String city, String state, String zip, int firstResult, int maxResults);
	InstanceRequest<RestaurantProxy, Void> persist();
	InstanceRequest<RestaurantProxy, Void> remove();
}
