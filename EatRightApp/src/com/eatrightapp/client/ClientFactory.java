package com.eatrightapp.client;

import com.eatrightapp.client.ui.UserAccountsView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {
	EventBus getEventBus();
    PlaceController getPlaceController();
    UserAccountsView getUserAccountsView();
}
