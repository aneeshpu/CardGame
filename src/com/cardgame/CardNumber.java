package com.cardgame;

public enum CardNumber {
	JACK, KING, QUEEN, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN;

	public boolean isGreaterThan(CardNumber other) {
		return this.ordinal() < other.ordinal();
	}
}
