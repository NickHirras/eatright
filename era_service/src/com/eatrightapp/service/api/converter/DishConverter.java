package com.eatrightapp.service.api.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.eatrightapp.service.api.model.Dish;

@XmlRootElement(name = "dish")
public class DishConverter {
	private Dish entity;

	public DishConverter() {
		entity = new Dish();
	}

	public DishConverter(Dish entity) {
		this.entity = entity;
	}

	public Dish getDish() {
		return entity;
	}

	@XmlElement
	public Long getId() {
		return entity.getId();
	}

	public void setId(Long id) {
		entity.setId(id);
	}

	@XmlElement
	public String getRestaurantId() {
		return entity.getRestaurantId();
	}

	public void setRestaurantId(String restaurantId) {
		entity.setRestaurantId(restaurantId);
	}

	@XmlElement
	public String getFranchiseId() {
		return entity.getFranchiseId();
	}

	public void setFranchiseId(String franchiseId) {
		entity.setFranchiseId(franchiseId);
	}

	@XmlElement
	public String getTitle() {
		return entity.getTitle();
	}

	public void setTitle(String title) {
		entity.setTitle(title);
	}

	@XmlElement
	public String getDescription() {
		return entity.getDescription();
	}

	public void setDescription(String description) {
		entity.setDescription(description);
	}
	
	@XmlElement
	public Long getImageId() {
		return entity.getImageId();
	}

	public void setImageId(Long imageId) {
		entity.setImageId(imageId);
	}
	
	@XmlElement
	public String getCreatedBy() {
		return entity.getCreatedBy();
	}

	public void setCreatedBy(String createdBy) {
		entity.setCreatedBy(createdBy);
	}

	@XmlElement
	public boolean isFlagged() {
		return entity.isFlagged();
	}

	public void setFlagged(boolean flagged) {
		entity.setFlagged(flagged);
	}

	@XmlElement
	public String getWhoFlagged() {
		return entity.getWhoFlagged();
	}

	public void setWhoFlagged(String whoFlagged) {
		entity.setWhoFlagged(whoFlagged);
	}
	
	@XmlElement
	public String getWhyFlagged() {
		return entity.getWhyFlagged();
	}

	public void setWhyFlagged(String whyFlagged) {
		entity.setWhyFlagged(whyFlagged);
	}
	
	@XmlElement
	public Set<String> getTags() {
		return entity.getTags();
	}
	
	public void setTags(Set<String> tags) {
		entity.setTags(tags);
	}
	
	@XmlElement
	public Integer getCalories() {
		return entity.getCalories();
	}
	
	public void setCalories(Integer calories) {
		entity.setCalories(calories);
	}

	@XmlElement
	public Integer getProtein() {
		return entity.getProtein();
	}
	
	public void setProtein(Integer protein) {
		entity.setProtein(protein);
	}

	@XmlElement
	public Integer getCarbs() {
		return entity.getCarbs();
	}
	
	public void setCarbs(Integer carbs) {
		entity.setCarbs(carbs);
	}

	@XmlElement
	public Integer getFat() {
		return entity.getFat();
	}
	
	public void setFat(Integer fat) {
		entity.setFat(fat);
	}
	
	@XmlElement
	public Integer getLikes() {
		return entity.getLikes();
	}
	
	public void setLikes(Integer likes) {
		entity.setLikes(likes);
	}

	@XmlElement
	public Integer getDislikes() {
		return entity.getDislikes();
	}
	
	public void setDislikes(Integer dislikes) {
		entity.setDislikes(dislikes);
	}

	public static List<DishConverter> wrap(List<Dish> list) {
		if(list == null)
			return null;
		
		List<DishConverter> newList = new ArrayList<DishConverter>();
		for(Dish d : list) {
			newList.add(new DishConverter(d));
		}
		
		return newList;
	}
	
}
