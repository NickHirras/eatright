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

import java.util.ArrayList;
import java.util.List;

import com.eatrightapp.admin.client.AdminClientFactory;
import com.eatrightapp.admin.client.place.UserAccountsPlace;
import com.eatrightapp.admin.client.ui.UserAccountsView;
import com.eatrightapp.shared.EatRightAppRequestFactory;
import com.eatrightapp.shared.UserAccountProxy;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
    private EatRightAppRequestFactory requestFactory;
    private UserAccountsPlace place;
    private UserAccountsView userAccountsView;
    
    public UserAccountsActivity(UserAccountsPlace place, AdminClientFactory clientFactory, EatRightAppRequestFactory requestFactory) {    	
    	this.place = place;
    	this.clientFactory = clientFactory;
    	this.requestFactory = requestFactory;    	
    }       
    
    @Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
    	userAccountsView = clientFactory.getUserAccountsView();
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

    public void populateTestData() {
//    	List<UserAccountProxy> userAccounts = new ArrayList<UserAccountProxy>();
//    	UserAccountProxy account;
//    	long counter = 0L;
//    	
//    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
//    	account.setId(counter++);
//    	account.setEmail("nick.smith@gmail.com");
//		account.setNickname("Nicholas Smith");
//		account.setComment("This is the site admin.");
//		account.setBanned(false);
//		userAccounts.add(account);
//
//    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
//    	account.setId(counter++);
//    	account.setEmail("imauser@aol.com");
//		account.setNickname("imauser@aol.com");
//		account.setComment("Just another user.");
//		account.setBanned(System.currentTimeMillis() % 2 == 0);
//		userAccounts.add(account);
//		
//    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
//    	account.setId(counter++);
//    	account.setEmail("teddyb43@yahoo.com");
//		account.setNickname("Mike S.");
//		account.setComment("");
//		account.setBanned(System.currentTimeMillis() % 2 == 0);
//		userAccounts.add(account);
//		
//    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
//    	account.setId(counter++);
//    	account.setEmail("benw@hotmail.com");
//		account.setNickname("Ben Williamson");
//		account.setComment("Temp moderator, may be revoke after 1/1/2011");
//		account.setBanned(System.currentTimeMillis() % 2 == 0);
//		userAccounts.add(account);
//		
//    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
//    	account.setId(counter++);
//    	account.setEmail("billg@corp.microsoft.com");
//		account.setNickname("William H. Gates");
//		account.setComment("");
//		account.setBanned(System.currentTimeMillis() % 2 == 0);
//		userAccounts.add(account);
//		
//    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
//    	account.setId(counter++);
//    	account.setEmail("philg@mit.edu");
//		account.setNickname("philg");
//		account.setComment("");
//		account.setBanned(System.currentTimeMillis() % 2 == 0);
//		userAccounts.add(account);
//		
//    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
//    	account.setId(counter++);
//    	account.setEmail("adboard@whataburger.com");
//		account.setNickname("Whataburger Ad Council");
//		account.setComment("");
//		account.setBanned(System.currentTimeMillis() % 2 == 0);
//		userAccounts.add(account);
//	
//    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
//    	account.setId(counter++);
//    	account.setEmail("jerry@menshealth.com");
//		account.setNickname("JerryBigz");
//		account.setComment("");
//		account.setBanned(System.currentTimeMillis() % 2 == 0);
//		userAccounts.add(account);
//		
//		userAccountsView.getUserAccountsCellTable().setRowData(0,userAccounts);
	}

	/**
     * Ask user before stopping this activity
     */
    @Override
    public String mayStop() {
        return null;
    }

	/**
     * Navigate to a new Place in the browser
     */
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
