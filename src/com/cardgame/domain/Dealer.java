package com.cardgame.domain;


public final class Dealer {

	private final Deck deck;
	private Tuple tuple;

	private class Tuple {
		private Card firstCard;
		private Card secondCard;

		private void add(Card card) {
			if (secondCardAlreadyPulled())
				throw new GameOverException("You can only pull out two cards");

			if (isFirstCardNotPulled()) {
				firstCard = card;
				return;

			}

			secondCard = card;
		}

		private boolean isFirstCardNotPulled() {
			return firstCard == null;
		}

		private boolean secondCardAlreadyPulled() {
			return secondCard != null;
		}

		public void reset() {
			firstCard = null;
			secondCard = null;
		}
	}

	public Dealer(Deck deck) {
		this.deck = deck;
		tuple = new Tuple();

	}

	public final Card draw() {

		Card randomCard = deck.randomCard();
		tuple.add(randomCard);
		return randomCard;
	}

	public final Result calculateResult() {
		Card winner = tuple.firstCard.higherThan(tuple.secondCard) ? tuple.firstCard : tuple.secondCard;
		Card loser = tuple.firstCard.lowerThan(tuple.secondCard) ? tuple.firstCard : tuple.secondCard;

		return new Result(winner, loser);

	}

	public final void reset() {
		tuple.reset();
	}
}