package com.eatrightapp.admin.client;

import com.eatrightapp.admin.client.mvp.AppActivityMapper;
import com.eatrightapp.admin.client.mvp.AppPlaceHistoryMapper;
import com.eatrightapp.admin.client.place.UserAccountsPlace;
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

    public void onModuleLoad() { 
        AdminClientFactory clientFactory = GWT.create(AdminClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
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
