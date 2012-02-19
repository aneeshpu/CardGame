package com.cardgame;

import com.cardgame.game.WeightedValue;

public final class Card implements Comparable<Card> {

	private final Symbol symbol;
	private final WeightedValue value;

	public Card(final Symbol symbol, final WeightedValue value) {
		this.symbol = symbol;
		this.value = value;

	}

	@Override
	public String toString() {
		return String.format("%s of %s", symbol, value);
	}

	@Override
	public int compareTo(final Card other) {
		if (this.equals(other))
			return 0;

		if (this.value.isHigherThan(other.value))
			return 1;
		return -1;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return value.equals(other.value);
	}

	public boolean higherThan(final Card other) {
		return compareTo(other) > 0;
	}

	public boolean lowerThan(final Card other) {
		return !higherThan(other);
	}

}
