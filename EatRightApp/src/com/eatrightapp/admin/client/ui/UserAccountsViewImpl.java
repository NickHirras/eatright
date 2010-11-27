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
 
import java.util.ArrayList;
import java.util.List;

import com.eatrightapp.shared.EatRightAppRequestFactory;
import com.eatrightapp.shared.UserAccountProxy;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.requestfactory.ui.client.LoginWidget;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class UserAccountsViewImpl extends Composite implements UserAccountsView {
	
	private static UserAccountsViewImplUiBinder uiBinder = GWT.create(UserAccountsViewImplUiBinder.class);
	
	private Presenter presenter;
	
	@UiField LoginWidget loginWidget;
	
	@UiField SimplePager pager;
	
	@UiField CellTable<UserAccountProxy> userAccountsCellTable;
	
	@UiTemplate("UserAccountsViewImpl.ui.xml")
	interface UserAccountsViewImplUiBinder extends UiBinder<Widget, UserAccountsViewImpl> {
	}
	
	private static class EmailCell extends AbstractCell<String> {

		@Override
		public void render(String value, Object key, SafeHtmlBuilder sb) {
			if(value == null) return;
			
			//SafeHtml shtml = SafeHtmlUtils.fromString(value);
			sb.appendHtmlConstant(value);
		}
		
	}
	
	public UserAccountsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		// Setup the User Accounts table.
		CheckboxCell checkboxcell = new CheckboxCell();
		Column<UserAccountProxy, Boolean> selectedColumn = new Column<UserAccountProxy, Boolean>(checkboxcell) {

			@Override
			public Boolean getValue(UserAccountProxy object) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		userAccountsCellTable.addColumn(selectedColumn, "Select");
		EmailCell emailCell = new EmailCell();
		Column<UserAccountProxy, String> emailColumn = new Column<UserAccountProxy, String>(emailCell) { 
			@Override
			public String getValue(UserAccountProxy userAccount) {
				StringBuilder sb = new StringBuilder();
				if(userAccount.getEmail() != null && userAccount.getEmail().length() > 0) {
					sb.append("<a href=mailto:\"");
					sb.append(userAccount.getEmail());
					sb.append("\">");					
				}
				if(userAccount.getNickname() != null && userAccount.getNickname().length() > 0) {
					sb.append(userAccount.getNickname());
				} else if(userAccount.getEmail() != null && userAccount.getEmail().length() > 0) {
					sb.append(userAccount.getEmail());
				}
				if(userAccount.getEmail() != null && userAccount.getEmail().length() > 0) {
					sb.append("</a>");
				}
				return sb.toString();
			}
		};
		userAccountsCellTable.addColumn(emailColumn, "Email");
		TextColumn<UserAccountProxy> commentColumn = new TextColumn<UserAccountProxy>() { 
			@Override
			public String getValue(UserAccountProxy userAccount) {
				return userAccount.getComment();
			}
		};
		userAccountsCellTable.addColumn(commentColumn, "Comments");
		TextColumn<UserAccountProxy> bannedColumn = new TextColumn<UserAccountProxy>() { 
			@Override
			public String getValue(UserAccountProxy userAccount) {
				if(userAccount.getBanned()) {
					return "BANNED";
				} else {
					return "";
				}
			}
		};
		userAccountsCellTable.addColumn(bannedColumn, "Banned");
		
		userAccountsCellTable.setPageSize(5);
		pager.setDisplay(userAccountsCellTable);
	}
	
	@Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
		
	public LoginWidget getLoginWidget() {
	    return loginWidget;
	}
	
	public SimplePager getPager() {
		return pager;
	}
	
	@Override
	public Button getPopulateTestDataButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserAccountsList(List<UserAccountProxy> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CellTable<UserAccountProxy> getUserAccountsCellTable() {
		return userAccountsCellTable;
	}
	
	@UiHandler("populateTestDataButton")
	void onClickPopulateTestData(ClickEvent e) {
    	List<UserAccountProxy> userAccounts = new ArrayList<UserAccountProxy>();
    	UserAccountProxy account;
    	long counter = 0L;
    	
    	EatRightAppRequestFactory requestFactory = GWT.create(EatRightAppRequestFactory.class);
    	
    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
    	account.setId(counter++);
    	account.setEmail("nick.smith@gmail.com");
		account.setNickname("Nicholas Smith");
		account.setComment("This is the site admin.");
		account.setBanned(false);
		userAccounts.add(account);

    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
    	account.setId(counter++);
    	account.setEmail("imauser@aol.com");
		account.setNickname("imauser@aol.com");
		account.setComment("Just another user.");
		account.setBanned(System.currentTimeMillis() % 2 == 0);
		userAccounts.add(account);
		
    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
    	account.setId(counter++);
    	account.setEmail("teddyb43@yahoo.com");
		account.setNickname("Mike S.");
		account.setComment("");
		account.setBanned(System.currentTimeMillis() % 2 == 0);
		userAccounts.add(account);
		
    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
    	account.setId(counter++);
    	account.setEmail("benw@hotmail.com");
		account.setNickname("Ben Williamson");
		account.setComment("Temp moderator, may be revoke after 1/1/2011");
		account.setBanned(System.currentTimeMillis() % 2 == 0);
		userAccounts.add(account);
		
    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
    	account.setId(counter++);
    	account.setEmail("billg@corp.microsoft.com");
		account.setNickname("William H. Gates");
		account.setComment("");
		account.setBanned(System.currentTimeMillis() % 2 == 0);
		userAccounts.add(account);
		
    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
    	account.setId(counter++);
    	account.setEmail("philg@mit.edu");
		account.setNickname("philg");
		account.setComment("");
		account.setBanned(System.currentTimeMillis() % 2 == 0);
		userAccounts.add(account);
		
    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
    	account.setId(counter++);
    	account.setEmail("adboard@whataburger.com");
		account.setNickname("Whataburger Ad Council");
		account.setComment("");
		account.setBanned(System.currentTimeMillis() % 2 == 0);
		userAccounts.add(account);
	
    	account = requestFactory.userAccountRequest().create(UserAccountProxy.class); 
    	account.setId(counter++);
    	account.setEmail("jerry@menshealth.com");
		account.setNickname("JerryBigz");
		account.setComment("");
		account.setBanned(System.currentTimeMillis() % 2 == 0);
		userAccounts.add(account);
		
		getUserAccountsCellTable().setRowData(0,userAccounts);
	}
	
}
