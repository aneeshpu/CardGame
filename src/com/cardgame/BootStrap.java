package com.cardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cardgame.domain.Dealer;
import com.cardgame.domain.Deck;
import com.cardgame.domain.Result;
import com.cardgame.game.Rummy;

class BootStrap {

	public static void main(final String[] args) throws IOException {

		final Dealer game = new Dealer(new Deck(new Rummy().weightedValues()));
		

		final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		do {
			game.reset();
			game.draw();
			game.draw();

			final Result result = game.calculateResult();

			System.out.println(result.print());

			input = bufferedReader.readLine();
		} while ("y".equals(input));

	}

}
