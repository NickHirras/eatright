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

package com.eatrightapp.admin.client.activity;

import com.eatrightapp.admin.client.AdminClientFactory;
import com.eatrightapp.admin.client.place.UserAccountsPlace;
import com.eatrightapp.admin.client.ui.UserAccountsView;
import com.eatrightapp.shared.EatRightAppRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.UserInformationProxy;
import com.google.gwt.requestfactory.ui.client.LoginWidget;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class UserAccountsActivity extends AbstractActivity implements UserAccountsView.Presenter {
	// Used to obtain views, eventBus, placeController
    private AdminClientFactory clientFactory;

    private final EatRightAppRequestFactory requestFactory; 
    
    public UserAccountsActivity(UserAccountsPlace place, AdminClientFactory clientFactory, EatRightAppRequestFactory requestFactory) {    	
    	this.clientFactory = clientFactory;
    	this.requestFactory = requestFactory;    	
    }       
    
    @Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    	UserAccountsView userAccountsView = clientFactory.getUserAccountsView();
    	userAccountsView.setPresenter(this);
    	
    	final LoginWidget loginWidget = userAccountsView.getLoginWidget();
    	Receiver<UserInformationProxy> receiver = new Receiver<UserInformationProxy>() {
    	      @Override
    	      public void onSuccess(UserInformationProxy userInformationRecord) {
    	    	  loginWidget.setUserInformation(userInformationRecord);
    	      }
    	    };
    	    requestFactory.userInformationRequest().getCurrentUserInformation(
    	        Location.getHref()).fire(receiver);
    	
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
