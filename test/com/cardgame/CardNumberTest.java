package com.cardgame;

import static org.hamcrest.core.Is.is;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardNumberTest {

	@Test
	public void compares_two_values() {
		assertThat(CardNumber.ACE.isGreaterThan(CardNumber.TWO), is(true));
	}
}
