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

import com.eatrightapp.server.domain.MenuItem;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(MenuItem.class)
interface MenuItemProxy extends EntityProxy {
	 Long getId();

	 RestaurantProxy getRestaurant();
	 
	 void setRestaurant(RestaurantProxy restaurant);
	 
	 String getItemName();

	 void setItemName(String itemName);

	 String getDescription();

	 void setDescription(String description);

	 Integer getCalories();

	 void setCalories(Integer calories);

	 Integer getFat();

	 void setFat(Integer fat);

	 Integer getProtein();

	 void setProtein(Integer protein);

	 Integer getCarbs();

	 void setCarbs(Integer carbs);

	 Boolean isBreakfast();

	 void setBreakfast(Boolean breakfast);

	 Boolean isLunch();

	 void setLunch(Boolean lunch);

	 Boolean isDinner();

	 void setDinner(Boolean dinner);

	 Float getRating();

	 void setRating(Float rating);

	 Long getRatingsCount();

	 void setRatingsCount(Long ratingsCount);

	 UserAccountProxy getModifiedBy();

	 void setModifiedBy(UserAccountProxy modifiedBy);

	 Date getModifiedDate();

	 void setModifiedDate(Date modifiedDate);

	 Boolean isSpam();

	 void setSpam(Boolean spam);

	 Boolean isInaccurate();

	 void setInaccurate(Boolean inaccurate);


}
