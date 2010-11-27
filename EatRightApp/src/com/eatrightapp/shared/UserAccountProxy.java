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

package com.eatrightapp.shared;

import com.eatrightapp.server.domain.UserAccount;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(UserAccount.class)
public interface UserAccountProxy extends EntityProxy {
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
