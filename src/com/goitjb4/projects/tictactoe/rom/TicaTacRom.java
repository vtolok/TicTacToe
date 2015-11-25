import java.util.ArrayList;
import java.util.List;

public class TicaTacRom extends TicaTacToe {

	static List<Abc> listWinLines = new ArrayList<Abc>();

	public TicaTacRom() {

		listWinLines.add(new Abc(0, 1, 2));
		listWinLines.add(new Abc(3, 4, 5));
		listWinLines.add(new Abc(6, 7, 8));

		listWinLines.add(new Abc(0, 3, 6));
		listWinLines.add(new Abc(1, 4, 7));
		listWinLines.add(new Abc(2, 5, 8));

		listWinLines.add(new Abc(0, 4, 8));
		listWinLines.add(new Abc(2, 4, 6));

	}

	private static boolean playerCanWin(int player, int[] board) {
		boolean res = false;

		for (Abc e : listWinLines) {
			res = RomUtils.checkLine(player, board, e.getA(), e.getB(), e.getC());
			if (res == true) {
				return true;
			}
		}

		return res;

	}

	@Override
	public int move(int player, int[] board) {

		int[] inputBoard = board.clone();
		int countFillCells = RomUtils.countOfFillCells(board);

		if (countFillCells <= 1) {
			return RomUtils.getIndexOfGoodPosition(board);
		} else {
			return benefitsOfProgress(player, inputBoard, null);
		}

	}

	private int benefitsOfProgress(int player, int[] board, Integer cell) {

		int maxValue, maxIndex, resValue;
		resValue = maxValue = 0;
		maxIndex = -1;
		int enemy = -player;

		int[] localBoard = board.clone();
		if (cell != null) {
			localBoard[cell] = enemy;

			return getWeigthOfThatStep(enemy, localBoard);

		} else {

			for (int i = 0; i < localBoard.length; i++) {

				localBoard = board.clone();
				if (localBoard[i] == 0) {
					localBoard[i] = player;
					if (playerCanWin(player, localBoard)) {
						return i;// WIN;
					}

					resValue = benefitsOfProgress(player, localBoard, i);

					if (resValue >= maxValue) {
						maxValue = resValue;
						maxIndex = i;
					}

				}
			}
		}

		if (maxValue == RomConst.UNCLEAR_SITUATION) {
			int IndexOfGoodPos = RomUtils.getIndexOfGoodPosition(localBoard);
			if (IndexOfGoodPos != -1) {
				maxIndex = IndexOfGoodPos;
			}
		}

		return maxIndex;
	}

	public static int getWeigthOfThatStep(int enemy, int[] board) {
		if (playerCanWin(enemy, board)) {
			return RomConst.ENEMY_CAN_WIN;
		}
		;

		if (RomUtils.canMove(board))
			return RomConst.UNCLEAR_SITUATION;
		else
			return RomConst.DRAW;
	}

}
