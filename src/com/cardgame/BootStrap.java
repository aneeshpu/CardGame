package com.cardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cardgame.domain.Dealer;
import com.cardgame.domain.Deck;
import com.cardgame.domain.Result;
import com.cardgame.game.Rummy;

class BootStrap {

	public static void main(String[] args) throws IOException {

		Dealer game = new Dealer(new Deck(new Rummy().weightedValues()));
		

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		do {
			game.reset();
			game.draw();
			game.draw();

			Result result = game.calculateResult();

			System.out.println(result.print());

			input = bufferedReader.readLine();
		} while (input.equals("y"));

	}

}
