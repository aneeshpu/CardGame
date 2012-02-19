package com.cardgame.game;

import com.cardgame.CardNumber;

public class WeightedValue {

	private final CardNumber cardNumber;
	private final int weight;

	public WeightedValue(CardNumber cardNumber, int weight) {
		this.cardNumber = cardNumber;
		this.weight = weight;
	}

	public boolean isHigherThan(WeightedValue value) {
		return weight > value.weight;
	}

	public String toString(){
		return cardNumber.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightedValue other = (WeightedValue) obj;
		if (cardNumber != other.cardNumber)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
}
