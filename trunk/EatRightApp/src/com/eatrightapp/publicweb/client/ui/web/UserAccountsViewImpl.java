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

package com.eatrightapp.publicweb.client.ui.web;
 
import com.eatrightapp.publicweb.client.ui.UserAccountsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UserAccountsViewImpl extends Composite implements UserAccountsView {
	private static UserAccountsViewImplUiBinder uiBinder = GWT.create(UserAccountsViewImplUiBinder.class);
	private Presenter presenter;
	
	interface UserAccountsViewImplUiBinder extends UiBinder<Widget, UserAccountsViewImpl> {
	}
	
	public UserAccountsViewImpl() {
		// TODO Not present in the examples, but here I had to cast the uiBinder call back to a Widget?
		initWidget((Widget) uiBinder.createAndBindUi(this));
	}
	
	@Override
    public void setPresenter(Presenter presenter) {
            this.presenter = presenter;
    }
}
