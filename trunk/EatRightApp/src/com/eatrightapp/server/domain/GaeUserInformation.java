package com.eatrightapp.server.domain;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.requestfactory.server.UserInformationSimpleImpl;

/**
 * A user information class that uses the Google App Engine authentication
 * framework
 */
// TODO: extends UserInformationSimpleImpl because I couldn't find UserInformationImpl
public class GaeUserInformation extends UserInformationSimpleImpl {
  public GaeUserInformation(String redirectUrl) {
		super(redirectUrl);
		// TODO Auto-generated constructor stub
	}

private static UserService userService = UserServiceFactory.getUserService();

  public static GaeUserInformation getCurrentUserInformation() {
    return new GaeUserInformation("");
  }
  
  public String getEmail() {
    User user = userService.getCurrentUser();
    if (user == null) {
      return "";
    }
    return user.getEmail();
  }

  public String getLoginUrl() {
    return userService.createLoginURL("RETURN_URL");
  }
  
  public String getLogoutUrl() {
    return userService.createLogoutURL("RETURN_URL");
  }
  
  public String getName() {
    User user = userService.getCurrentUser();
    if (user == null) {
      return "";
    }
    return user.getNickname();
  }
  
  public Long getId() {
    User user = userService.getCurrentUser();
    if (user == null) {
      return 0L;
    }
    return new Long(user.hashCode());
  }
  
  public boolean isUserLoggedIn() {
    return userService.isUserLoggedIn();
  }
  
}