package com.eatrightapp.shared;

import com.eatrightapp.server.domain.EatRightAppUser;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(EatRightAppUser.class)
interface EatRightAppUserProxy extends EntityProxy {
	Long getId();

	String getUserId();

	void setUserId(String userId);
	
	String getEmail();

	void setEmail(String email);
	
	String getNickname();

	void setNickname(String nickname);

	String getFederatedIdentity();

	void setFederatedIdentity(String federatedIdentity);

	String getComment();

	void setComment(String comment);

	Boolean getBanned();

	void setBanned(Boolean banned);

}
