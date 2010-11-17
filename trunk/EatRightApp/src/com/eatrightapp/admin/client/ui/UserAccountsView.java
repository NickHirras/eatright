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

package com.eatrightapp.admin.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.ui.client.LoginWidget;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.IsWidget;

public interface UserAccountsView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	public interface Presenter {
        void goTo(Place place);
    }
	
	LoginWidget getLoginWidget();
	
	SimplePager getPager();
	
}
