package com.goitjb4.projects.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class AIRoman extends AbstractAI {

	private static final int PLAYER_X = 1;
	private static final int PLAYER_O = -1;
	
	private static final int RATIO = 100; 
	private static final int X_WIN = PLAYER_X * RATIO;
	private static final int O_WIN = PLAYER_O * RATIO;
	private static final int DRAW = 0;

	private List<Abc> listWinLines = new ArrayList<Abc>();
	private int[] inputBoard;

	public AIRoman() {
		listWinLines.add(new Abc(0, 1, 2));
		listWinLines.add(new Abc(3, 4, 5));
		listWinLines.add(new Abc(6, 7, 8));

		listWinLines.add(new Abc(0, 3, 6));
		listWinLines.add(new Abc(1, 4, 7));
		listWinLines.add(new Abc(2, 5, 8));

		listWinLines.add(new Abc(0, 4, 8));
		listWinLines.add(new Abc(2, 4, 6));

	}

	private boolean playerWin(int player) {
		for (Abc e : listWinLines) {
			if ((inputBoard[e.getA()] == player) && (inputBoard[e.getB()] == player)
					&& (inputBoard[e.getC()] == player)) {
				return true;
			}
		}
		return false;
	}

	@Override
	 public int move(int[] board, int player) {
		inputBoard = board.clone();
		int maxIndex = -1;
		if (boardIsEmpty(inputBoard)) {
			maxIndex = (int) (Math.random() * (inputBoard.length));
		} else {
			int res = benefitsOfProgress(player, inputBoard, 0);
			maxIndex = res - cutOffMove(res);
		}
		return maxIndex;
	}

	
	private int cutOffMove(int i) {
		if (i == 0) {
			return i;
		}
		return ((int) (i / RATIO)) * RATIO;
	}
	
	private int benefitsOfProgress(int player, int[] board, int depth) {
		if (playerWin(PLAYER_X)) {
			return X_WIN;
		} else if (playerWin(PLAYER_O)) {
			return O_WIN;
		} else if (!canMove(board)) {
			return DRAW;
		}

		int resVal = 0;
		if (player == PLAYER_X) {
			resVal = O_WIN;
		} else {
			resVal = X_WIN;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				board[i] = player;
				int enemyVal = benefitsOfProgress(-player, board, depth + 1);
				//System.out.println("player = " + player + ", move = " + i + ", resVal = " + resVal + ", enemyVal = " + enemyVal + ", depth = " + depth);
				if (((player == PLAYER_X) && (cutOffMove(enemyVal) > cutOffMove(resVal)))
						|| ((player == PLAYER_O) && (cutOffMove(enemyVal) < cutOffMove(resVal)))) {
					resVal = cutOffMove(enemyVal);
					if (resVal < 0) {
						resVal -= i; 
					} else {
						resVal += i;
					}
				}
				board[i] = 0;
			}
		}
		return resVal;
	}

	private boolean boardIsEmpty(int[] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[i] != 0)
				return false;
		}
		return true;
	}	
	
	private boolean canMove(int[] board) {

		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0)
				return true;
		}
		return false;
	}

	private class Abc {
		private int a;
		private int b;
		private int c;

		public Abc(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public int getA() {
			return a;
		}

		public int getB() {
			return b;
		}

		public int getC() {
			return c;
		}

	}

}
