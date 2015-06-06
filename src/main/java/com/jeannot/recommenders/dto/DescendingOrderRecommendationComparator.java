package com.jeannot.recommenders.dto;

import java.util.Comparator;

/**
 * Returns recommendations in a descending order of average rating
 *
 */
public class DescendingOrderRecommendationComparator implements Comparator<Recommendation> {

	public int compare(Recommendation o1, Recommendation o2) {
		if (o1.getAverageRating() > o2.getAverageRating()) {
			return -1;
		} else {
			return 1;
		}
	}
}
