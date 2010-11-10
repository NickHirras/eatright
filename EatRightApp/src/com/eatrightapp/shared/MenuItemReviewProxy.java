package com.eatrightapp.shared;

import java.util.Date;

import com.eatrightapp.server.domain.MenuItemReview;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(MenuItemReview.class)
interface MenuItemReviewProxy extends EntityProxy {
	Long getId();
	
	MenuItemProxy getMenuItem();

	void setMenuItem(MenuItemProxy menuItem);
	
	EatRightAppUserProxy getAuthor();

	void setAuthor(EatRightAppUserProxy author);

	Date getDateCreated();

	void setDateCreated(Date dateCreated);

	Integer getRating();

	void setRating(Integer rating);
	
	String getComment();

	void setComment(String comment);

	String getImageBlobKey();

	void setImageBlobKey(String imageBlobKey);

	Boolean getInappropriate();

	void setInappropriate(Boolean inappropriate);

	Boolean getSpam();

	void setSpam(Boolean spam);

}
