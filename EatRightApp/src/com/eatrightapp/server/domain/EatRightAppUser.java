package com.eatrightapp.server.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;

import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.UserInformationProxy;

@Entity
public class EatRightAppUser implements UserInformationProxy {

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

	public static Long countUsers() {
		// TODO implement EatRightAppUser.countUsers
		return null;
	}
	
	public static Long countModerators() {
		// TODO implement EatRightAppUser.countModerators
		return null;
	}
	
	public static EatRightAppUser findUserById(String id) {
		// TODO implement EatRightAppUser.findUserByUserId
		if(id == null) {
			return null;
		}
		
		EntityManager em = entityManager();
		try {
			EatRightAppUser user = em.find(EatRightAppUser.class, id);
			return user;
		} finally {
			em.close();
		}
	}
	
	public static List<EatRightAppUser> findUsersByEmailOrNickname(String email, String nickname, int firstResult, int maxResults) {
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

	@Override
	public EntityProxyId<?> stableId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoginUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLogoutUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
