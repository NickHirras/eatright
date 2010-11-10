package com.eatrightapp.publicweb.client.mvp;

import com.eatrightapp.publicweb.client.place.UserAccountsPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({UserAccountsPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
