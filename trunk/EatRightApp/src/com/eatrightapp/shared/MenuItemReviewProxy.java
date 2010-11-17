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

import com.eatrightapp.server.domain.MenuItemReview;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(MenuItemReview.class)
interface MenuItemReviewProxy extends EntityProxy {
	Long getId();
	
	MenuItemProxy getMenuItem();

	void setMenuItem(MenuItemProxy menuItem);
	
	UserAccountProxy getAuthor();

	void setAuthor(UserAccountProxy author);

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
