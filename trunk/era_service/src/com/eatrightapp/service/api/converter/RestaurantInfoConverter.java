package com.eatrightapp.service.api.converter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.eatrightapp.service.api.model.RestaurantInfo;

@XmlRootElement(name = "restaurantInfo")
public class RestaurantInfoConverter {
	private RestaurantInfo entity;

	public RestaurantInfoConverter() {
		entity = new RestaurantInfo();
	}

	public RestaurantInfoConverter(RestaurantInfo entity) {
		this.entity = entity;
	}

	public RestaurantInfo getRestaurantInfo() {
		return entity;
	}

	@XmlElement
	public String getId() {
		return entity.getId();
	}

	public void setId(String id) {
		entity.setId(id);
	}

	@XmlElement
	public boolean isFranchise() {
		return entity.isFranchise();
	}

	public void setFranchise(boolean franchise) {
		entity.setFranchise(franchise);
	}

	@XmlElement
	public String getFranchiseId() {
		return entity.getFranchiseId();
	}

	public void setFranchiseId(String franchiseId) {
		entity.setFranchiseId(franchiseId);
	}

	@XmlElement
	public boolean isFlagged() {
		return entity.isFlagged();
	}

	public void setFlagged(boolean flagged) {
		entity.setFlagged(flagged);
	}
}
