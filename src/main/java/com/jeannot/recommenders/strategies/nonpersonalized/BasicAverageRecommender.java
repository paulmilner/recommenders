package com.jeannot.recommenders.strategies.nonpersonalized;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.jeannot.recommenders.dto.Product;
import com.jeannot.recommenders.dto.Rating;
import com.jeannot.recommenders.dto.Recommendation;

public class BasicAverageRecommender {
	
	/**
	 * Uses floating point division to get an average of integral ratings
	 * @param product
	 * @return
	 */
	public static float getAverageRating(Product product) {
		List<Rating> ratings = product.getRatings();
		float countOfRatings = (float) ratings.size();
		float totalRatings = 0f;
		for (Rating rating : ratings) {
			totalRatings = totalRatings + rating.getValue();
		}
		float averageRating = totalRatings / countOfRatings;
		return averageRating;
	}

	public static List<Recommendation> getRecommendations(List<Product> products) {
		
		Set<Recommendation> recommendations = new TreeSet<Recommendation>();
		for (Product product : products) {
			
			float averageRating = getAverageRating(product);
			
		}
		return null;
	}
	
}
