package com.eatrightapp.shared;

import java.util.List;

import com.eatrightapp.server.domain.EatRightAppUser;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(EatRightAppUser.class)
public interface EatRightAppUserRequest extends RequestContext {
	Request<Long> countUsers();
	Request<Long> countModerators();
	Request<List<EatRightAppUserProxy>> findUsers(String email, String nickname, int firstResult, int maxResults);
	InstanceRequest<EatRightAppUserProxy, Void> persist();
	InstanceRequest<EatRightAppUserProxy, Void> remove();
}
