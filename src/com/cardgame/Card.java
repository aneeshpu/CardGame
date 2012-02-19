package com.cardgame;

public final class Card implements Comparable<Card> {

	private final Symbol symbol;
	private final CardNumber value;

	public Card(final Symbol symbol, final CardNumber value) {
		this.symbol = symbol;
		this.value = value;

	}

	@Override
	public String toString() {
		return String.format("%s of %s", symbol, value);
	}

	@Override
	public int compareTo(Card other) {
		if (this.equals(other))
			return 0;

		if (this.value.isGreaterThan(other.value))
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (value != other.value)
			return false;
		return true;
	}

}
