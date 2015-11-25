package com.goitjb4.projects.tictactoe;

public abstract class AbstractAI {
	
	abstract int move(int[] board, int player);

	public static void clearTheBoard(int[] board) {
		for (int i = 0; i < board.length; i++) {
			board[i] = 0;
		}
	}
	
}
