package com.eatrightapp.client.ui.web;
 
import com.eatrightapp.client.ui.UserAccountsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UserAccountsViewImpl extends Composite implements UserAccountsView {
	private static UserAccountsViewImplUiBinder uiBinder = GWT.create(UserAccountsViewImplUiBinder.class);
	private Presenter presenter;
	
	interface UserAccountsViewImplUiBinder extends UiBinder {
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
