package com.cardgame.game;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.cardgame.Card;

public class GameTest {

	@Test
	public void draws_cards() {

		Game game = new Game(new Rummy());
		Card card = game.draw();

		assertThat(card != null, is(true));

	}

}
