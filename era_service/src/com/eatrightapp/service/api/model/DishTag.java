package com.eatrightapp.service.api.model;

import javax.persistence.Id;

public class DishTag {
	@Id
	private String tag;

	public DishTag() {

	}

	public DishTag(String tag) {
		this.tag = tag;
	}


	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("com.eatrightapp.service.api.model.DishTag: ");
		sb.append("tag=\"").append(tag).append("\"");
		return sb.toString();
	}

}
