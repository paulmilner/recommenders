package com.jeannot.recommenders.strategies.nonpersonalized;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@Test
	public void should_return_ordered_recommendations_of_two_items() throws Exception {
		
		Set<Product> products = new HashSet<Product>();
		
		List<Rating> ratings2 = new ArrayList<Rating>();
		ratings2.add(new Rating(1));
		ratings2.add(new Rating(1));
		Product productWithTwoBottomRatings = new Product(2,"product 2",ratings2);
		products.add(productWithTwoBottomRatings);
		
		List<Rating> ratings = new ArrayList<Rating>();
		ratings.add(new Rating(5));
		ratings.add(new Rating(5));
		Product productWithTwoTopRatings = new Product(1,"product 1",ratings);
		products.add(productWithTwoTopRatings);
		
		Set<Recommendation> recommendations = BasicAverageRecommender.getRecommendations(products,5);

		//Print the ordered list of recommendations in descending order of recommendations
		for (Recommendation recommendation : recommendations) {
			System.out.println(recommendation.toString());
		}
		
	}
	
	@Test
	public void should_return_ordered_recommendations_of_various_items() throws Exception {
		
		Set<Product> products = new HashSet<Product>();
		
		products.add(new Product(1,"Cheese",new ArrayList<Rating>(Arrays.asList(new Rating(5),new Rating(4)))));
		products.add(new Product(2,"Bread",new ArrayList<Rating>(Arrays.asList(new Rating(1),new Rating(4)))));
		products.add(new Product(3,"Ham",new ArrayList<Rating>(Arrays.asList(new Rating(2)))));
		products.add(new Product(4,"Onions",new ArrayList<Rating>(Arrays.asList(new Rating(5),new Rating(4),new Rating(5)))));
		products.add(new Product(5,"Pickles",new ArrayList<Rating>(Arrays.asList(new Rating(2),new Rating(1)))));
		products.add(new Product(6,"Tomatoes",new ArrayList<Rating>(Arrays.asList(new Rating(5),new Rating(1)))));
		products.add(new Product(7,"Potatos",new ArrayList<Rating>(Arrays.asList(new Rating(4)))));
		products.add(new Product(8,"Spring Onions",new ArrayList<Rating>(Arrays.asList(new Rating(2),new Rating(2),new Rating(3),new Rating(4)))));
		products.add(new Product(9,"Orange Juice",new ArrayList<Rating>(Arrays.asList(new Rating(5),new Rating(5)))));
		
		Set<Recommendation> recommendations = BasicAverageRecommender.getRecommendations(products,10);

		//Print the ordered list of recommendations in descending order of recommendations
		for (Recommendation recommendation : recommendations) {
			System.out.println(recommendation.toString());
		}
		
	}
	
	@Test
	public void should_return_ordered_recommendations_limited_to_a_given_size() throws Exception {
		
		Set<Product> products = new HashSet<Product>();
		
		products.add(new Product(1,"Cheese",new ArrayList<Rating>(Arrays.asList(new Rating(5),new Rating(4)))));
		products.add(new Product(2,"Bread",new ArrayList<Rating>(Arrays.asList(new Rating(1),new Rating(4)))));
		products.add(new Product(3,"Ham",new ArrayList<Rating>(Arrays.asList(new Rating(2)))));
		products.add(new Product(4,"Onions",new ArrayList<Rating>(Arrays.asList(new Rating(5),new Rating(4),new Rating(5)))));
		products.add(new Product(5,"Pickles",new ArrayList<Rating>(Arrays.asList(new Rating(2),new Rating(1)))));
		products.add(new Product(6,"Tomatoes",new ArrayList<Rating>(Arrays.asList(new Rating(5),new Rating(1)))));
		products.add(new Product(7,"Potatos",new ArrayList<Rating>(Arrays.asList(new Rating(4)))));
		products.add(new Product(8,"Spring Onions",new ArrayList<Rating>(Arrays.asList(new Rating(2),new Rating(2),new Rating(3),new Rating(4)))));
		products.add(new Product(9,"Orange Juice",new ArrayList<Rating>(Arrays.asList(new Rating(5),new Rating(5)))));
		
		int limit = 5;
		Set<Recommendation> recommendations = BasicAverageRecommender.getRecommendations(products,limit);
		assertEquals("We should get " + limit + " items back",limit,recommendations.size());

		//Print the ordered list of recommendations in descending order of recommendations
		for (Recommendation recommendation : recommendations) {
			System.out.println(recommendation.toString());
		}
		
	}
	
}
