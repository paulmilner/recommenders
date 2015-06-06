package com.jeannot.recommenders.dto;

public class Rating {
	
	private static final int MIN_RATING = 1;
	private static final int MAX_RATING = 5;
	
	private int value;
	
	public Rating(int value) {
		super();
		if (value<MIN_RATING || value>MAX_RATING) {
			throw new IllegalArgumentException("Value must be between minimum rating (" + MIN_RATING + ") and maximum rating (" + MAX_RATING + ")");
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Rating [value=" + value + "]";
	}

}
