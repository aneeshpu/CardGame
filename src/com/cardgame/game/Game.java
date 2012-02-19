package com.cardgame.game;

import com.cardgame.Card;
import com.cardgame.Deck;

public class Game {

	private final Deck deck;
	private Tuple tuple;
	private final GameStrategy gameStrategy;

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
	
	public Game(GameStrategy gameStrategy){
		this.gameStrategy = gameStrategy;
		deck = new Deck(gameStrategy.weightedValues());
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

	public void reset() {
		tuple.reset();
	}


}
