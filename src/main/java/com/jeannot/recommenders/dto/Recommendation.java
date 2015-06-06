package com.jeannot.recommenders.dto;

public class Recommendation {
	
	private float averageRating;
	private Product product;
	
	public Recommendation(float averageRating, Product product) {
		super();
		this.averageRating = averageRating;
		this.product = product;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "Recommendation [averageRating=" + averageRating + ", product="
				+ product + "]";
	}

}
