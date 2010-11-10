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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String userId;
	
	private String email;
	
	private String nickname;
	
	private String federatedIdentity;
	
	private String comment;
	
	private Boolean banned;

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