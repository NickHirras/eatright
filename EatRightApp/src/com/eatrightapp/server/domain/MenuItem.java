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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class MenuItem {

	private Integer version = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Restaurant restaurant;
	
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
	private UserAccount modifiedBy;
	
	@NotNull
	private Date modifiedDate;
	
	private Boolean spam;
	
	private Boolean inaccurate;
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Boolean getBreakfast() {
		return breakfast;
	}

	public Boolean getLunch() {
		return lunch;
	}

	public Boolean getDinner() {
		return dinner;
	}

	public Boolean getSpam() {
		return spam;
	}

	public Boolean getInaccurate() {
		return inaccurate;
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

	public void setBreakfast(Boolean breakfast) {
		this.breakfast = breakfast;
	}

	public void setLunch(Boolean lunch) {
		this.lunch = lunch;
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

	public void setSpam(Boolean spam) {
		this.spam = spam;
	}

	public void setInaccurate(Boolean inaccurate) {
		this.inaccurate = inaccurate;
	}

	// Entity Service Implementation //////////////////////////////////////////////////
	
	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}
	
	public static Long countMenuItems() {
		// TODO implement MenuItem.countMenuItems
		return null;
	}
	
	public static Long countMenuItemsByPlace(String placesReference, String placesUrl) {
		// TODO implement MenuItem.countMenuItemsByPlace
		return null;
	}

	public static MenuItem findMenuItem(Long id) {
		// TODO implement MenuItem.findMenuItem
		return null;
	}
	
	public static List<MenuItem> findMenuItemsByPlace(String placesReference, String placesUrl, int firstResult, int maxResults) {
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
