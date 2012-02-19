package com.cardgame.game;

import java.util.ArrayList;
import java.util.List;

import com.cardgame.CardNumber;

public class EveryOtherGame implements GameStrategy {

	@Override
	public List<WeightedValue> weightedValues() {
		List<WeightedValue> arrayList = new ArrayList<WeightedValue>();

		CardNumber[] values = CardNumber.values();

		for (int i = 0; i < values.length; i++) {
			arrayList.add(new WeightedValue(values[i], i));
		}

		return arrayList;
	}

}
