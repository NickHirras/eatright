package com.eatrightapp.shared;

import java.util.List;

import com.eatrightapp.server.domain.UserAccount;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(UserAccount.class)
public interface UserAccountRequest extends RequestContext {
	Request<Long> countUsers();
	Request<Long> countModerators();
	Request<UserAccountProxy> findUserById(String id);
	Request<List<UserAccountProxy>> findUsersByEmailOrNickname(String email, String nickname, int firstResult, int maxResults);
	InstanceRequest<UserAccountProxy, Void> persist();
	InstanceRequest<UserAccountProxy, Void> remove();
}
