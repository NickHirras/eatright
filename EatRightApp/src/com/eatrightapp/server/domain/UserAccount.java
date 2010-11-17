package com.eatrightapp.server.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userId;
	
	private String nickname;
	
	private String email;

	private String comment;
	
	private Boolean banned;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private String getUserId() {
		return userId;
	}
	
	private void setUserId(String userId) {
		this.userId = userId;
	}
	
	private String getNickname() {
		return nickname;
	}
	
	private void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	private String getEmail() {
		return email;
	}
	
	private void setEmail(String email) {
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
