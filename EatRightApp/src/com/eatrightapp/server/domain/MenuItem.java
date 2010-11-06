package com.eatrightapp.server.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.google.appengine.api.users.User;

@Entity
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String placesReference;
	
	private String placesUrl;
	
	@NotNull
	private String itemName;
	
	private String description;
	
	private Integer calories;
	
	private Integer fat;
	
	private Integer protein;
	
	private Integer carbs;
	
	private Boolean breakfast;
	
	private Boolean lunch;
	
	private Boolean dinner;
	
	@Min(value = 0)
	@Max(value = 5)
	private Float rating;
	
	private Long ratingsCount;
	
	@NotNull
	private User modifiedBy;
	
	@NotNull
	private Date modifiedDate;
	
	private Boolean spam;
	
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getFat() {
		return fat;
	}

	public void setFat(Integer fat) {
		this.fat = fat;
	}

	public Integer getProtein() {
		return protein;
	}

	public void setProtein(Integer protein) {
		this.protein = protein;
	}

	public Integer getCarbs() {
		return carbs;
	}

	public void setCarbs(Integer carbs) {
		this.carbs = carbs;
	}

	public Boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}

	public Boolean isLunch() {
		return lunch;
	}

	public void setLunch(Boolean lunch) {
		this.lunch = lunch;
	}

	public Boolean isDinner() {
		return dinner;
	}

	public void setDinner(Boolean dinner) {
		this.dinner = dinner;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Long getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(Long ratingsCount) {
		this.ratingsCount = ratingsCount;
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

	public Boolean isSpam() {
		return spam;
	}

	public void setSpam(Boolean spam) {
		this.spam = spam;
	}

	public Boolean isInaccurate() {
		return inaccurate;
	}

	public void setInaccurate(Boolean inaccurate) {
		this.inaccurate = inaccurate;
	}

	// Entity Service Implementation //////////////////////////////////////////////////
	
	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}
	
	public Long countMenuItems() {
		// TODO implement MenuItem.countMenuItems
		return null;
	}
	
	public Long countMenuItemsByPlace(String placesReference, String placesUrl) {
		// TODO implement MenuItem.countMenuItemsByPlace
		return null;
	}
	
	public List<MenuItem> findMenuItemsByPlace(String placesReference, String placesUrl, int firstResult, int maxResults) {
		// TODO implement MenuItem.findMenuItemsByPlace
		return null;
	}
	
	public void persist() {
		// TODO implement MenuItem.persist
		
	}
	
	public void remove() {
		// TODO implement MenuItem.remove
	}
	
}
