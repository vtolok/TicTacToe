package com.goitjb4.projects.tictactoe;
public class AIRomanEntry {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		int[] board = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		AbstractAI t = new AIRoman();

		int counter = 0;

		while (counter <= 9) {
			++counter;
			int player = 1;
			if (counter % 2 == 0) {
				player = -1;
			}
			((AIRoman) t).NextMove(player, board, t);
		}

	}

}