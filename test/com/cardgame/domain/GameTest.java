package com.cardgame.domain;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.cardgame.domain.Card;
import com.cardgame.domain.Dealer;
import com.cardgame.domain.Deck;
import com.cardgame.game.Rummy;

public class GameTest {

	@Test
	public void draws_cards() {

		Dealer game = new Dealer(new Deck(new Rummy().weightedValues()) );
		Card card = game.draw();

		assertThat(card != null, is(true));

	}

}
