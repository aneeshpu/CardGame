package com.cardgame.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.cardgame.domain.Card;
import com.cardgame.domain.Deck;
import com.cardgame.game.Rummy;

public class DeckTest {

	@Test
	public void gives_a_random_card() {
		
		Deck deck = new Deck(new Rummy().weightedValues());
		Card randomCard = deck.randomCard();
		System.out.println(randomCard);
		assertThat(randomCard != null, is(true));
	}
	
}
