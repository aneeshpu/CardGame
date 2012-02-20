package com.cardgame.domain;

public final class Dealer {

	private final Deck deck;
	private final Tuple tuple;

	private final class Tuple {
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

	public Card draw() {

		final Card randomCard = deck.randomCard();
		tuple.add(randomCard);
		return randomCard;
	}

	public Result calculateResult() {
		final Card winner = tuple.firstCard.higherThan(tuple.secondCard) ? tuple.firstCard : tuple.secondCard;
		final Card loser = tuple.firstCard.lowerThan(tuple.secondCard) ? tuple.firstCard : tuple.secondCard;

		return new Result(winner, loser);

	}

	public void reset() {
		tuple.reset();
	}
}