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
