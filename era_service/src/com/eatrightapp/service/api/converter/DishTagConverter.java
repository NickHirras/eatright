package com.eatrightapp.service.api.converter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.eatrightapp.service.api.model.DishTag;

@XmlRootElement(name = "dishTag")
public class DishTagConverter {
	private DishTag entity;

	public DishTagConverter() {
		entity = new DishTag();
	}

	public DishTagConverter(DishTag entity) {
		this.entity = entity;
	}

	public DishTag getDishTag() {
		return entity;
	}

	@XmlElement
	public String getTag() {
		return entity.getTag();
	}

	public void setTag(String tag) {
		entity.setTag(tag);
	}	
}
