package com.eatrightapp.client.activity;

import com.eatrightapp.client.ClientFactory;
import com.eatrightapp.client.place.UserAccountsPlace;
import com.eatrightapp.client.ui.UserAccountsView;
//import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class UserAccountsActivity extends AbstractActivity implements UserAccountsView.Presenter {
	// Used to obtain views, eventBus, placeController
    private ClientFactory clientFactory;

    public UserAccountsActivity(UserAccountsPlace place, ClientFactory clientFactory) {
    	this.clientFactory = clientFactory;
    }
    
    @Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    	UserAccountsView userAccountsView = clientFactory.getUserAccountsView();
    	userAccountsView.setPresenter(this);
        containerWidget.setWidget(userAccountsView.asWidget());
	}

    /**
     * Ask user before stopping this activity
     */
    @Override
    public String mayStop() {
        return "Please hold on. This activity is stopping.";
    }

	/**
     * Navigate to a new Place in the browser
     */
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
