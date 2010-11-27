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

package com.eatrightapp.server.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {

	private Integer version = 0;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userId;
	
	private String email;
	
	private String nickname;

	private String comment;
	
	private Boolean banned;

	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getBanned() {
		return banned;
	}

	public void setBanned(Boolean banned) {
		this.banned = banned;
	}
	
	
	// Entity Service Implementation //////////////////////////////////////////////////

	public static Long countUsers() {
		// TODO implement EatRightAppUser.countUsers
		return null;
	}
	
	public static Long countModerators() {
		// TODO implement EatRightAppUser.countModerators
		return null;
	}
	
	public static UserAccount findUser(Long id) {
		// TODO implement EatRightAppUser.findUser
		return null;
	}
	
	public static UserAccount findUserById(String id) {
		// TODO implement EatRightAppUser.findUserByUserId
		if(id == null) {
			return null;
		}
		
		EntityManager em = entityManager();
		try {
			UserAccount user = em.find(UserAccount.class, id);
			return user;
		} finally {
			em.close();
		}
	}
	
	public static List<UserAccount> findUsersByEmailOrNickname(String email, String nickname, int firstResult, int maxResults) {
		// TODO implement EatRightAppUser.findUsers
		return null;
	}
	
	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}

	
	public void persist() {
		// TODO implement EatRightAppUser.persist
	}
	
	public void remove() {
		// TODO implement EatRightAppUser.remove
	}

}
