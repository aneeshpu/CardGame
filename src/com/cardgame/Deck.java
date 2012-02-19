package com.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Deck {

	private final Random random = new Random();
	private final List<Card> deck;

	public Deck() {

		deck = new ArrayList<Card>() {
			{
				Symbol[] values = Symbol.values();
				for (Symbol symbol : values) {
					for (CardNumber value : CardNumber.values()) {
						Card card = new Card(symbol, value);
						add(card);
					}
				}
			}
		};

	}

	public final Card randomCard() {
		return deck.remove(random.nextInt(deck.size()));
	}

}
