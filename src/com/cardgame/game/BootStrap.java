package com.cardgame.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BootStrap {

	public static void main(String[] args) throws IOException {

		Game game = new Game(new Rummy());
		

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
