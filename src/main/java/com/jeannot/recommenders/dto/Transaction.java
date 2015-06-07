package com.jeannot.recommenders.dto;

import java.util.List;

public class Transaction {
	
	private List<Product> products;

	public Transaction(List<Product> products) {
		super();
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	

}
