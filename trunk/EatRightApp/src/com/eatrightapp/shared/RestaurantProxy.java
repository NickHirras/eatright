package com.eatrightapp.shared;

import java.util.Date;

import com.eatrightapp.server.domain.Restaurant;
import com.google.appengine.api.users.User;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(Restaurant.class)
interface RestaurantProxy extends EntityProxy {

	Long getId();

	String getPlacesReference();

	void setPlacesReference(String placesReference);

	String getPlacesUrl();

	void setPlacesUrl(String placesUrl);

	Boolean getIndependent();

	void setIndependent(Boolean independent);

	String getRestaurantName();

	void setRestaurantName(String restaurantName);

	String getCity();

	void setCity(String city);

	String getState();

	void setState(String state);

	String getZip();

	void setZip(String zip);

	User getModifiedBy();

	void setModifiedBy(User modifiedBy);

	Date getModifiedDate();

	void setModifiedDate(Date modifiedDate);

	Boolean getInaccurate();

	void setInaccurate(Boolean inaccurate);	
	
}
