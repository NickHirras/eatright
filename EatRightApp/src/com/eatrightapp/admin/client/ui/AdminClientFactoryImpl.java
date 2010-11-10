package com.eatrightapp.admin.client.ui;

import com.eatrightapp.admin.client.AdminClientFactory;
import com.eatrightapp.admin.client.ui.UserAccountsView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class AdminClientFactoryImpl implements AdminClientFactory {
    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final UserAccountsView userAccountsView = new UserAccountsViewImpl();

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public UserAccountsView getUserAccountsView() {
		return userAccountsView;
	}

}
