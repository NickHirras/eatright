package com.eatrightapp.shared;

import com.google.gwt.requestfactory.shared.RequestFactory;

public interface EatRightAppRequestFactory extends RequestFactory {
	
	MenuItemRequest menuItemRequest();
	
	MenuItemReviewRequest menuItemReviewRequest();
	
}
