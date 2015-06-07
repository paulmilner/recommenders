package com.jeannot.recommenders.strategies.nonpersonalized;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jeannot.recommenders.dto.Product;
import com.jeannot.recommenders.dto.Transaction;
import com.jeannot.recommenders.services.TransactionService;

public class SimilarProductRecommender {
	
	private TransactionService transactionService;
	
	public SimilarProductRecommender() {
		transactionService = TransactionService.getInstance();
	}
	
	/**
	 * Return the top n products "associated in a complementary way" (bought with?) this product
	 * e.g. garlic + olive paste... ice cream maker + ice cream scoop... etc.
	 * TODO have to figure how best to model that product x was also linked with product y.
	 * Here we just build the whole thing at runtime - not possible if lots of Transactions...
	 * This naive version doesn't take account of relative popularity - e.g. the "banana problem"
	 * where many products would be associated (in a supermarket) with bananas because most people who buy x also buy bananas...
	 * (There will be a less naive implementation later)
	 * @param product
	 * @param limit maximum products to return, starting with most "closely" linked
	 * @return list of products (sorted by closeness)
	 */
	public List<Product> getComplementaryProducts(Product product, int limit) {
		
		List<Product> products = new ArrayList<Product>();
		if (limit==0) return products;
		
		List<Transaction> transactions = transactionService.getAllTransactions();
		for (Transaction transaction : transactions) {
			List<Product> transactionProducts = transaction.getProducts();
			for (Product transactionProduct : transactionProducts) {
				//Aggregate and order by transactions where the product appears with other products...
			}
		}
		
		//Having figured out the product order, trim it down to the limit to be returned
		Iterator<Product> iterator = products.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			iterator.next();
			if (count>=limit) {
				iterator.remove();
			}
			count++;
		}
		return products;
	}
	
}
