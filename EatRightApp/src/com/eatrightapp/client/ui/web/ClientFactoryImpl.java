package com.eatrightapp.client.ui.web;

import com.eatrightapp.client.ClientFactory;
import com.eatrightapp.client.ui.UserAccountsView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {
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
