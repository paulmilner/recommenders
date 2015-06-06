package com.jeannot.recommenders.strategies.nonpersonalized;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jeannot.recommenders.dto.Product;
import com.jeannot.recommenders.dto.Rating;
import com.jeannot.recommenders.dto.Recommendation;

public class BasicAverageRecommenderTest {
	
	@Test
	public void should_return_correct_average_of_product_with_one_rating() throws Exception {
		
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating(5));
		Product product = new Product(1,"name1",ratings);
		assertEquals(5.0,BasicAverageRecommender.getAverageRating(product),0.0);

	}
	
	@Test
	public void should_return_average_of_one_product_with_some_ratings_all_the_same() throws Exception {
		
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating(5));
		ratings.add(new Rating(5));
		ratings.add(new Rating(5));
		ratings.add(new Rating(5));
		ratings.add(new Rating(5));
		Product product = new Product(1,"name2",ratings);
		assertEquals(5.0,BasicAverageRecommender.getAverageRating(product),0.0); //must be exactly 5
	
	}
	
	/**
	 * To make sure we're not accidentally using integer division here
	 * @throws Exception
	 */
	@Test
	public void should_return_average_of_one_product_with_some_ratings_which_give_a_fractional_average() throws Exception {
		
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating(4));
		ratings.add(new Rating(4));
		ratings.add(new Rating(4));
		ratings.add(new Rating(4));
		ratings.add(new Rating(5));
		Product product = new Product(1,"name1",ratings);
		assertEquals(4.2,BasicAverageRecommender.getAverageRating(product),0.01); //there can be a discrepancy beyond 2 decimal places!
	}
	
	@Test
	public void should_return_average_of_one_product_with_some_ratings() throws Exception {
		
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating(5));
		ratings.add(new Rating(4));
		ratings.add(new Rating(3));
		ratings.add(new Rating(2));
		ratings.add(new Rating(1));
		Product product = new Product(1,"name1",ratings);
		assertEquals(3.0,BasicAverageRecommender.getAverageRating(product),0.0); //must be exactly 3
	}
	
	@Test @Ignore
	public void should_return_average_of_some_items() throws Exception {
		
		List<Product> products = new ArrayList<Product>();
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating(5));
		Product mostPopularProduct = new Product(1,"",ratings);
		
		
		List<Recommendation> recommendations = BasicAverageRecommender.getRecommendations(products);
		
		
	}
	
}
