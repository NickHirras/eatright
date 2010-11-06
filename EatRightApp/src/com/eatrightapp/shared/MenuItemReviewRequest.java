package com.eatrightapp.shared;

import java.util.List;

import com.eatrightapp.server.domain.MenuItemReview;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(MenuItemReview.class)
public interface MenuItemReviewRequest extends RequestContext {
	Request<Long> countMenuItemReviews();
	Request<Long> countMenuItemReviewsByMenuItem(MenuItemProxy menuItem);
	Request<List<MenuItemReviewProxy>> findMenuItemReviewsByMenuItem(MenuItemProxy menuItem, int firstResult, int maxResults);
	InstanceRequest<MenuItemReviewProxy, Void> persist();
	InstanceRequest<MenuItemReviewProxy, Void> remove();

}
