package com.cardgame.game;

import java.util.ArrayList;
import java.util.List;

import com.cardgame.CardNumber;

public class Rummy implements GameStrategy{

	@Override
	public List<WeightedValue> weightedValues() {

		List<WeightedValue> arrayList = new ArrayList<WeightedValue>();

		CardNumber[] values = CardNumber.values();

		for (int i = values.length - 1,j=0; i >= 0; i--,j++) {
			arrayList.add(new WeightedValue(values[i], j));
		}
		
		return arrayList;
	}
}
