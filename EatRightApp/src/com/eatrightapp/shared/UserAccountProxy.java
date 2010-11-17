package com.eatrightapp.shared;

import com.eatrightapp.server.domain.UserAccount;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(UserAccount.class)
interface UserAccountProxy extends EntityProxy {
	Long getId();

	void setId(Long id);
	
	String getUserId();
	
	void setUserId(String userId);
	
	String getNickname();
	
	void setNickname(String nickname);
	
	String getEmail();
	
	void setEmail(String email);
	
	String getComment();

	void setComment(String comment);

	Boolean getBanned();

	void setBanned(Boolean banned);
	
}
