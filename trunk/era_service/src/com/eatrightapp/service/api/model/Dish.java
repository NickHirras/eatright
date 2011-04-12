package com.eatrightapp.service.api.model;

import java.util.Set;

import javax.persistence.Id;

public class Dish {
	@Id
	private Long id;
	private String restaurantId;
	private String franchiseId;
	private String title;
	private String description;
	private Long imageId;
	private String createdBy;
	private Set<String> tags;
	private boolean flagged;
	private String whoFlagged;
	private String whyFlagged;
	private int calories;
	private int protein;
	private int fat;
	private int carbs;
	private int likes;
	private int dislikes;
	
	public Dish() {

	}

	public Dish(Long id, String restaurantId, String franchiseId, 
				String title, String description, String createdBy, Set<String> tags, 
				boolean flagged, String whyFlagged, String whoFlagged,
				Integer calories, Integer protein, Integer fat, Integer carbs,
				Integer likes, Integer dislikes) {
		setId(id);
		setRestaurantId(restaurantId);
		setFranchiseId(franchiseId);
		setCreatedBy(createdBy);
		setTags(tags);
		setTitle(title);
		setDescription(description);
		setFlagged(flagged);
		setWhyFlagged(whyFlagged);
		setWhoFlagged(whoFlagged);
		setCalories(calories);
		setProtein(protein);
		setFat(fat);
		setCarbs(carbs);
		setLikes(likes);
		setDislikes(dislikes);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getFranchiseId() {
		return franchiseId;
	}

	public void setFranchiseId(String franchiseId) {
		this.franchiseId = franchiseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public String getWhyFlagged() {
		return whyFlagged;
	}

	public void setWhyFlagged(String whyFlagged) {
		this.whyFlagged = whyFlagged;
	}
	
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setWhoFlagged(String whoFlagged) {
		this.whoFlagged = whoFlagged;
	}

	public String getWhoFlagged() {
		return whoFlagged;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getProtein() {
		return protein;
	}

	public int getFat() {
		return fat;
	}

	public int getCarbs() {
		return carbs;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("com.eatrightapp.service.api.model.Dish: ");
		sb.append("id=\"").append(id).append("\", ");
		sb.append("restaurantId=").append(restaurantId).append(", ");
		sb.append("franchiseId=").append(franchiseId).append(", ");
		sb.append("title=").append(title).append(", ");
		sb.append("description=").append(description).append(", ");
		sb.append("createdBy=").append(createdBy).append(", ");
		sb.append("tags=");
		if(tags == null) {
			sb.append("null");
		} else {
			for(String tag: tags) {
				sb.append("(").append(tag).append(") ");
			}
		}
		sb.append(", ");
		sb.append("flagged=").append(flagged).append(", ");
		sb.append("whyFlagged=").append(whyFlagged).append(", ");
		sb.append("whoFlagged=").append(whoFlagged).append(", ");
		sb.append("calories=").append(calories).append(", ");
		sb.append("protein=").append(protein).append(", ");
		sb.append("fat=").append(fat).append(", ");
		sb.append("carbs=").append(carbs).append(" ");
		return sb.toString();
	}

}
