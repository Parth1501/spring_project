package com.rakuten.training.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	int id;
	
	@Column(name="product_name")
	String name;
	
	@Column(name="product_price")
	double price;
	
	@Column(name="product_qoh")
	int qoh;
	
	@Column(name="product_url")
	String url;
	
	@OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	@JoinColumn(name="pid")
	List<Review> reviews=new ArrayList<>();
	
	
	
	
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Product() {
		super();
	}
	public Product(String name, double price, int qoh,String url) {
		super();
		this.name = name;
		this.price = price;
		this.qoh = qoh;
		this.url=url;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQoh() {
		return qoh;
	}
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", qoh=" + qoh + "]";
	}
	
	
	
	
	
	
}
