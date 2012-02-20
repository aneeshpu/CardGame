package com.cardgame.domain;


public final class Result {

	private final Card winner;
	private final Card loser;

	public Result(final Card winner, final Card loser) {
		this.winner = winner;
		this.loser = loser;
	}
	
	private boolean isTie(){
		return winner.equals(loser);
	}
	
	public String print(){
		if(isTie()){
			return String.format("It is a tie between %s and %s", winner, loser);
		}
		
		return String.format("%s wins over %s", winner, loser);
	}

}
