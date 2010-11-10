package com.eatrightapp.publicweb.client.mvp;

import com.eatrightapp.publicweb.client.ClientFactory;
import com.eatrightapp.publicweb.client.activity.UserAccountsActivity;
import com.eatrightapp.publicweb.client.place.UserAccountsPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof UserAccountsPlace) {
            return new UserAccountsActivity((UserAccountsPlace) place, clientFactory);
        }
        return null;
    }

}
