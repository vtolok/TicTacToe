package com.goitjb4.projects.tictactoe;

import java.util.Arrays;

public class AIKoss extends AbstractAI {

	private static final int BOARD_SIZE = 9;
	private static final int PLAYER_X = 1;
	private static final int PLAYER_O = -1;
	private static final int PLAYER_X_WON = 4;
	private static final int DRAWN_GAME = 3;
	private static final int PLAYER_O_WON = 2;
	
	private static final int[][] WIN_PATTERNS = { 
			{ 0, 1, 2 }, // Row 1
			{ 3, 4, 5 }, // Row 2
			{ 6, 7, 8 }, // Row 3
			{ 0, 3, 6 }, // Column 1
			{ 1, 4, 7 }, // Column 2
			{ 2, 5, 8 }, // Column 3
			{ 0, 4, 8 }, // Diagonal 1
			{ 2, 4, 6 }  // Diagonal 2
	};

	private class Node {

		public int score;
		public int index;

		public Node() {
		}

		public Node(int score, int index) {
			this.score = score;
			this.index = index;
		}
	}
	
	private int[] board = new int[BOARD_SIZE];

	@Override
	public int move(int[] board, int player) {
		this.board = Arrays.copyOf(board, BOARD_SIZE);
		int res = -1;
		if (isBoardEmpty()) {
			res = (int) (Math.random() * BOARD_SIZE);
		} else {
			Node node = minimax(player);
			res = node.index;
		}
		return res;
	}

	private boolean isBoardEmpty() {
		for (int i = 0; i < board.length; i++) {
			if (board[i] != 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isBoardFull() {
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				return false;
			}
		}
		return true;
	}

	private int getWin() {
		for (int i = 0; i < WIN_PATTERNS.length; i++) {
			if (board[WIN_PATTERNS[i][0]] != 0 
					&& board[WIN_PATTERNS[i][0]] == board[WIN_PATTERNS[i][1]]
					&& board[WIN_PATTERNS[i][0]] == board[WIN_PATTERNS[i][2]]) {
				return board[WIN_PATTERNS[i][0]];
			}
		}
		return 0;
	}

	private int isGameOver() {
		int win = getWin();
		if (win == PLAYER_X) {
			return PLAYER_X_WON;
		} else if (win == PLAYER_O) {
			return PLAYER_O_WON;
		} else if (isBoardFull()) {
			return DRAWN_GAME;
		} else {
			return 0;
		}
	}

	private Node minimax(int player) {
		int end = isGameOver();
		if (end != 0) {
			return new Node(end, 0);
		}
		Node best = new Node();
		best.score = (player == PLAYER_X) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				board[i] = player;
				Node opp = minimax(-player);
				board[i] = 0;
				if ((player * opp.score) > (player * best.score)) {
					best.index = i;
					best.score = opp.score;
				}
			}
		}
		return best;
	}
	
}
