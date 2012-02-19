package com.cardgame;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardTest {

	@Test
	public void prints_a_human_readable_representation() {
		Card card = new Card(Symbol.CLUB, CardNumber.FOUR);
		assertThat(card.toString(), is("CLUB of FOUR"));
	}

	@Test
	public void higher_card_wins() {
		Card aceOfClub = new Card(Symbol.CLUB, CardNumber.ACE);
		Card twoOfDiamond = new Card(Symbol.DIAMOND, CardNumber.TWO);

		assertThat(aceOfClub.compareTo(twoOfDiamond) > 0, is(true));
	}

	@Test
	public void knows_the_same_card() {
		Card aceOfClub = new Card(Symbol.CLUB, CardNumber.ACE);
		Card anotherAceOfClub = new Card(Symbol.CLUB, CardNumber.ACE);

		assertThat(aceOfClub, is(anotherAceOfClub));
	}

	@Test
	public void compares_the_same_card_correctly() {

		Card aceOfClub = new Card(Symbol.CLUB, CardNumber.ACE);
		Card anotherAceOfClub = new Card(Symbol.CLUB, CardNumber.ACE);

		assertThat(aceOfClub.compareTo(anotherAceOfClub) == 0, is(true));
	}

	@Test
	public void knows_a_lower_card() {
		Card aceOfClub = new Card(Symbol.CLUB, CardNumber.ACE);
		Card twoOfDiamond = new Card(Symbol.DIAMOND, CardNumber.TWO);

		assertThat(twoOfDiamond.compareTo(aceOfClub) < 0, is(true));
	}

}
