package com.cardgame.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cardgame.Card;
import com.cardgame.Deck;

public class Game {

	private final Deck deck;
	private Tuple tuple;

	private class Tuple {
		private Card firstCard;
		private Card secondCard;

		private void add(Card card) {
			if (secondCardAlreadyAdded())
				throw new GameAlreadyOverException("You can only pull out two cards");

			if (firstCard == null) {
				firstCard = card;
				return;

			}

			secondCard = card;
		}

		private boolean secondCardAlreadyAdded() {
			return secondCard != null;
		}

		public void reset() {
			firstCard = null;
			secondCard = null;
		}
	}

	public Game() {
		deck = new Deck();
		tuple = new Tuple();
	}

	public Card draw() {

		Card randomCard = deck.randomCard();
		tuple.add(randomCard);
		return randomCard;
	}

	public Result calculateResult() {
		Card winner = tuple.firstCard.higherThan(tuple.secondCard) ? tuple.firstCard : tuple.secondCard;
		Card loser = tuple.firstCard.lowerThan(tuple.secondCard) ? tuple.firstCard : tuple.secondCard;

		return new Result(winner, loser);

	}

	private void reset() {
		tuple.reset();
	}

	public static void main(String[] args) throws IOException {

		Game game = new Game();

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
