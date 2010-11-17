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

package com.eatrightapp.server.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Restaurant {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String placesReference;
	
	private String placesUrl;

	private Boolean independent;
	
	private String restaurantName;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private UserAccount modifiedBy;
	
	private Date modifiedDate;
	
	private Boolean inaccurate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlacesReference() {
		return placesReference;
	}

	public void setPlacesReference(String placesReference) {
		this.placesReference = placesReference;
	}

	public String getPlacesUrl() {
		return placesUrl;
	}

	public void setPlacesUrl(String placesUrl) {
		this.placesUrl = placesUrl;
	}

	public Boolean getIndependent() {
		return independent;
	}

	public void setIndependent(Boolean independent) {
		this.independent = independent;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public UserAccount getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(UserAccount modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getInaccurate() {
		return inaccurate;
	}

	public void setInaccurate(Boolean inaccurate) {
		this.inaccurate = inaccurate;
	}
	
	// Entity Service Implementation //////////////////////////////////////////////////

	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}

	public Long countRestaurants() {
		// TODO implement Restaurant.countRestaurants
		return null;
	}
	
	public List<Restaurant> findRestaurantsByName(String restaurantName, int firstResult, int maxResults) {
		// TODO implement Restaurant.findRestaurantsByName 
		return null;
	}
	
	public List<Restaurant> findRestaurantsByUrl(String url, int firstResult, int maxResults) {
		// TODO implement Restaurant.findRestaurantsByUrl
		return null;
	}
	
	public List<Restaurant> findRestaurantsByLocation(String city, String state, String zip, int firstResult, int maxResults) {
		// TODO implement Restaurant.findRestaurantsByLocation
		return null;
	}
	
	public void persist() {
	}
	
	public void remove() {
	}
	
}
