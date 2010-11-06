package com.eatrightapp.shared;

import java.util.List;

import com.eatrightapp.server.domain.MenuItem;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(MenuItem.class)
public interface MenuItemRequest extends RequestContext {
	Request<Long> countMenuItems();
	Request<Long> countMenuItemsByPlace(String placesReference, String placesUrl);
	Request<List<MenuItemProxy>> findMenuItemsByPlace(String placesReference, String placesUrl, int firstResult, int maxResults);
	InstanceRequest<MenuItemProxy, Void> persist();
	InstanceRequest<MenuItemProxy, Void> remove();
}
