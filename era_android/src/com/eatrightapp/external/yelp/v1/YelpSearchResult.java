package com.eatrightapp.external.yelp.v1;

import java.util.List;

public class YelpSearchResult {
	private Message message;
	private List<Business> businesses;
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public List<Business> getBusinesses() {
		return businesses;
	}
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
	
}
