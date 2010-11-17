/*
 * Copyright 2010 Nicholas Smith
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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
	Request<RestaurantProxy> findRestaurant(Long id);
	Request<List<RestaurantProxy>> findRestaurantsByName(String restaurantName, int firstResult, int maxResults);
	Request<List<RestaurantProxy>> findRestaurantsByUrl(String url, int firstResult, int maxResults);
	Request<List<RestaurantProxy>> findRestaurantsByLocation(String city, String state, String zip, int firstResult, int maxResults);
	InstanceRequest<RestaurantProxy, Void> persist();
	InstanceRequest<RestaurantProxy, Void> remove();
}
