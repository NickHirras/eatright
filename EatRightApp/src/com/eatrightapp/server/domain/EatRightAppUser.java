package com.eatrightapp.server.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class EatRightAppUser {

	@Id	
	private String id;
	
	private String email;
	
	private String nickname;
	
	private String federatedIdentity;
	
	private String comment;
	
	private Boolean banned;
	
	private Boolean moderator;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFederatedIdentity() {
		return federatedIdentity;
	}

	public void setFederatedIdentity(String federatedIdentity) {
		this.federatedIdentity = federatedIdentity;
	}
	
	public Boolean getModerator() {
		return moderator;
	}
	
	public void setModerator(Boolean moderator) {
		this.moderator = moderator;
	}
	
	// Entity Service Implementation //////////////////////////////////////////////////

	public Long countUsers() {
		// TODO implement EatRightAppUser.countUsers
		return null;
	}
	
	public Long countModerators() {
		// TODO implement EatRightAppUser.countModerators
		return null;
	}
	
	public List<EatRightAppUser> findUsersByEmailOrNickname(String email, String nickname, int firstResult, int maxResults) {
		// TODO implement EatRightAppUser.findUsers
		return null;
	}
	
	public void persist() {
		// TODO implement EatRightAppUser.persist
	}
	
	public void remove() {
		// TODO implement EatRightAppUser.remove
	}

}
