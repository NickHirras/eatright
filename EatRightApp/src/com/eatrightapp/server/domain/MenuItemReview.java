package com.eatrightapp.server.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class MenuItemReview {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private MenuItem menuItem;
	
	private UserAccount author;
	
	private Date dateCreated;
	
	@Min(value=0)
	@Max(value=5)
	private Integer rating;
	
	private String comment;
	
	private String imageBlobKey;
	
	private Boolean inappropriate;
	
	private Boolean spam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public UserAccount getAuthor() {
		return author;
	}

	public void setAuthor(UserAccount author) {
		this.author = author;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImageBlobKey() {
		return imageBlobKey;
	}

	public void setImageBlobKey(String imageBlobKey) {
		this.imageBlobKey = imageBlobKey;
	}

	public Boolean getInappropriate() {
		return inappropriate;
	}

	public void setInappropriate(Boolean inappropriate) {
		this.inappropriate = inappropriate;
	}

	public Boolean getSpam() {
		return spam;
	}

	public void setSpam(Boolean spam) {
		this.spam = spam;
	}

	// Entity Service Implementation //////////////////////////////////////////////////
	
	public static final EntityManager entityManager() {
		return EMF.get().createEntityManager();
	}
	
	public Long countMenuItemReviews() {
		// TODO implement MenuItemReview.countMenuItemReviews
		return null;
	}
	public Long countMenuItemReviewsByMenuItem(MenuItem menuItem) {
		// TODO implement MenuItemReview.countMenuItemReviewsByMenuItem
		return null;
	}
	public List<MenuItemReview> findMenuItemReviewsByMenuItem(MenuItem menuItem, int firstResult, int maxResults) {
		// TODO implement MenuItemReview.findMenuItemReviewsByMenuItem
		return null;
	}
	public void persist() {
		// TODO implement MenuItemReview.persist
	}
	public void remove() {
		// TODO implement MenuItemReview.remove
	}


}
