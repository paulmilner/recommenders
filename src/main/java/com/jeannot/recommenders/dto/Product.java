package com.jeannot.recommenders.dto;

import java.util.List;

public class Product {
	
	private long id;
	private String name;
	private List<Rating> ratings;
	
	public Product(long id, String name, List<Rating> ratings) {
		super();
		this.id = id;
		//TODO null checks
		this.name = name;
		this.ratings = ratings;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Rating> getRatings() {
		return ratings;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", ratings=" + ratings
				+ "]";
	}
	
	
}
