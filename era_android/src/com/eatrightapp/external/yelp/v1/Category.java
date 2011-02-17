package com.eatrightapp.external.yelp.v1;

public class Category {
	private String categoryFilter;
	private String name;
	private String searchUrl;
	
	public String getCategoryFilter() {
		return categoryFilter;
	}
	public void setCategoryFilter(String categoryFilter) {
		this.categoryFilter = categoryFilter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSearchUrl() {
		return searchUrl;
	}
	public void setSearchUrl(String searchUrl) {
		this.searchUrl = searchUrl;
	}
}
