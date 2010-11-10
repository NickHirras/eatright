package com.eatrightapp.admin.client;

import com.eatrightapp.admin.client.ui.UserAccountsView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface AdminClientFactory {
	EventBus getEventBus();
    PlaceController getPlaceController();
    UserAccountsView getUserAccountsView();
}
