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

package com.eatrightapp.shared;

import java.util.Date;

import com.eatrightapp.server.domain.Restaurant;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(Restaurant.class)
public interface RestaurantProxy extends EntityProxy {

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

	UserAccountProxy getModifiedBy();

	void setModifiedBy(UserAccountProxy modifiedBy);

	Date getModifiedDate();

	void setModifiedDate(Date modifiedDate);

	Boolean getInaccurate();

	void setInaccurate(Boolean inaccurate);	
	
}
