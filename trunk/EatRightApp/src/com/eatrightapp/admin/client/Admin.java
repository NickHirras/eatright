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

package com.eatrightapp.admin.client;

import com.eatrightapp.admin.client.mvp.AppActivityMapper;
import com.eatrightapp.admin.client.mvp.AppPlaceHistoryMapper;
import com.eatrightapp.admin.client.place.UserAccountsPlace;
import com.eatrightapp.shared.EatRightAppRequestFactory;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Admin implements EntryPoint {
    private Place userAccountsPlace = new UserAccountsPlace();
    private SimplePanel appWidget = new SimplePanel();
	private EatRightAppRequestFactory requestFactory;

    public void onModuleLoad() { 
        AdminClientFactory clientFactory = GWT.create(AdminClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();
        requestFactory = GWT.create(EatRightAppRequestFactory.class);
        requestFactory.initialize(eventBus);

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory, requestFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, userAccountsPlace);

        DOM.removeChild(RootPanel.getBodyElement(), DOM.getElementById("admin_content"));        
        RootLayoutPanel.get().add(appWidget);    
        
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();
    }
}
