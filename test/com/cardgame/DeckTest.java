package com.cardgame;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DeckTest {

	@Test
	public void gives_a_random_card() {
		
		Deck deck = new Deck();
		Card randomCard = deck.randomCard();
		System.out.println(randomCard);
		assertThat(randomCard != null, is(true));
	}
	
}
