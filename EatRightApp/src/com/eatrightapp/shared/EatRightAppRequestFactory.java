package com.eatrightapp.shared;

import com.google.gwt.requestfactory.shared.RequestFactory;
import com.google.gwt.requestfactory.shared.UserInformationRequest;

public interface EatRightAppRequestFactory extends RequestFactory {
	
	MenuItemRequest menuItemRequest();
	
	MenuItemReviewRequest menuItemReviewRequest();
	
	UserInformationRequest userInformationRequest();	
	
}
