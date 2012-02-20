package com.cardgame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Deck {

	private final Random random = new Random();
	private final List<Card> deck;

	public Deck(final List<WeightedValue> weightedValues) {

		deck = new ArrayList<Card>();

		for (Symbol symbol : Symbol.values()) {
			for (WeightedValue value : weightedValues) {
				deck.add(new Card(symbol, value));
			}
		}

	}

	public final Card randomCard() {
		return deck.remove(random.nextInt(deck.size()));
	}

}
