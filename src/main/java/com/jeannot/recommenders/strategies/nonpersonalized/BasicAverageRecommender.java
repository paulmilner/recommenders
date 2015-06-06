package com.jeannot.recommenders.strategies.nonpersonalized;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.jeannot.recommenders.dto.Product;
import com.jeannot.recommenders.dto.Rating;
import com.jeannot.recommenders.dto.Recommendation;
import com.jeannot.recommenders.dto.DescendingOrderRecommendationComparator;

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

	/**
	 * Return the top n recommendations from a set of products
	 * @param products
	 * @param limit maximum products to return, starting from the highest average rated product
	 * @return list of recommended products
	 */
	public static Set<Recommendation> getRecommendations(Set<Product> products, int limit) {
		
		Set<Recommendation> recommendations = new TreeSet<Recommendation>(new DescendingOrderRecommendationComparator());
		if (limit==0) return recommendations;
		
		for (Product product : products) {
			float averageRating = getAverageRating(product);
			Recommendation recommendation = new Recommendation(averageRating,product);
			recommendations.add(recommendation);
		}
		
		//Having figured out the recommendation order, trim it down to the limit to be returned
		Iterator<Recommendation> iterator = recommendations.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			iterator.next();
			if (count>=limit) {
				iterator.remove();
			}
			count++;
		}
		
		return recommendations;
	}
	
}
