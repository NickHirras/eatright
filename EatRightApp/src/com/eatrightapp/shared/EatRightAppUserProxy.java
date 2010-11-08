package com.eatrightapp.shared;

import com.eatrightapp.server.domain.EatRightAppUser;
import com.google.appengine.api.users.User;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(EatRightAppUser.class)
interface EatRightAppUserProxy extends EntityProxy {
	Long getId();

	User getUser();

	void setUser(User user);

	String getComment();

	void setComment(String comment);

	Boolean getBanned();

	void setBanned(Boolean banned);

}
