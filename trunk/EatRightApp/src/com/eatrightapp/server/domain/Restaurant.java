package com.eatrightapp.server.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.google.appengine.api.users.User;

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
	
	private User modifiedBy;
	
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

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
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
