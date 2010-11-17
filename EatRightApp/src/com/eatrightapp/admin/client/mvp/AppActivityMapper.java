/*
 * Copyright 2010 Nicholas Smith
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
 
package com.eatrightapp.admin.client.mvp;

import com.eatrightapp.admin.client.AdminClientFactory;
import com.eatrightapp.admin.client.activity.UserAccountsActivity;
import com.eatrightapp.admin.client.place.UserAccountsPlace;
import com.eatrightapp.shared.EatRightAppRequestFactory;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {
	private AdminClientFactory clientFactory;
	private EatRightAppRequestFactory requestFactory;

    public AppActivityMapper(AdminClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
        this.requestFactory = GWT.create(EatRightAppRequestFactory.class);
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof UserAccountsPlace) {
            return new UserAccountsActivity((UserAccountsPlace) place, clientFactory, requestFactory);
        }
        return null;
    }

}
