package com.rakuten.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String reviewer;

	String details;

	int rating;
	
	@ManyToOne
	@JoinColumn(name="pid")
	Product product;
	
	
	public int getId() {
		return id;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Review() {
		super();
	}

	public Review(String reviewer, String details, int rating) {
		super();
		this.reviewer = reviewer;
		this.details = details;
		this.rating = rating;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewer=" + reviewer + ", details=" + details + ", rating=" + rating
				+ ", product=" + product + "]";
	}
	
	
	
	
}
