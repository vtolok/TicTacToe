package com.goitjb4.projects.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AIKoss extends AbstractAI {

	private static final int BOARD_SIZE = 9;

	private static final int PLAYER_X = 1;
	private static final int PLAYER_O = -1;

	private static final int PLAYER_X_WON = 4;
	private static final int DRAWN_GAME = 3;
	private static final int PLAYER_O_WON = 2;

	private static final int[][] WIN_PATTERNS = { //
			{ 0, 1, 2 }, // ROW1
			{ 3, 4, 5 }, // ROW2
			{ 6, 7, 8 }, // ROW3
			{ 0, 3, 6 }, // COL1
			{ 1, 4, 7 }, // COL2
			{ 2, 5, 8 }, // COL3
			{ 0, 4, 8 }, // DIAGONAL1
			{ 2, 4, 6 }, // DIAGONAL2
	};

	private class Node {
		
		public int best;
		public int index;

		public Node() {
			this.best = 0;
			this.index = 0;
		}

		public Node(int best, int index) {
			this.best = best;
			this.index = index;
		}
	}

	private int[] board = new int[BOARD_SIZE];

	@Override
	public int move(int[] board, int player) {
		this.board = Arrays.copyOf(board, BOARD_SIZE);
		int res = -1;
		if (isEmpty()) {
			res = (int) (Math.random() * BOARD_SIZE);
		} else {
			Node node = minimax(player);
			res = node.index;
		}
		return res;
	}

	private boolean isEmpty() {
		for (int i = 0; i < board.length; i++) {
			if (board[i] != 0)
				return false;
		}
		return true;
	}

	private boolean isFull() {
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0)
				return false;
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
		} else if (isFull()) {
			return DRAWN_GAME;
		} else
			return 0;
	}

	public List<Integer> getAvailableMoves() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0)
				list.add(i);
		}
		return list;
	}	
	
	private Node minimax(int player) {
		int end = isGameOver();
		if (end != 0) {
			return new Node(end, 0);
		}
		Node res = new Node();
		res.best = (player == PLAYER_X) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for (int i : getAvailableMoves()) {
			board[i] = player;
			Node opp = minimax(-player);
			board[i] = 0;
			if ((player * opp.best) > (player * res.best)) {
				res.index = i;
				res.best = opp.best;
			}
		}
		return res;
	}

}