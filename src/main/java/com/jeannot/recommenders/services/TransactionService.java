package com.jeannot.recommenders.services;

import java.util.ArrayList;
import java.util.List;

import com.jeannot.recommenders.dto.Transaction;

public class TransactionService {
	
	private static TransactionService me;
	
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public TransactionService() {
		//NOOP
	}
	
	public static TransactionService getInstance() {
		if (me==null) {
			me = new TransactionService();
		}
		return me;
	}
	
	public List<Transaction> getAllTransactions() {
		return transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

}
