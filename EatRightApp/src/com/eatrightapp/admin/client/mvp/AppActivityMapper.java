package com.eatrightapp.admin.client.mvp;

import com.eatrightapp.admin.client.AdminClientFactory;
import com.eatrightapp.admin.client.activity.UserAccountsActivity;
import com.eatrightapp.admin.client.place.UserAccountsPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {
	private AdminClientFactory clientFactory;

    public AppActivityMapper(AdminClientFactory clientFactory) {
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
