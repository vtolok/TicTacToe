public class RomUtils {

	public static boolean checkLine(int x, int[] board, int a, int b, int c) {
		return (board[a] == x) & (board[b] == x) & (board[c] == x);
	}



	public static void ShowTheBoard(int[] board) {
		int counter = 0;
		System.out.println("-------");
		for (int i : board) {
			counter++;

			if (i >= 0) {
				System.out.print(" " + i + " ");
			} else
				System.out.print(i + " ");

			if (counter % 3 == 0) {
				System.out.println("");
			}

		}
	}

	public static int countOfFillCells(int[] board) {
		int count = 0;
		for (int intCell : board) {
			if (intCell != 0) {
				count++;
			}
		}
		return count;
	}

	public static boolean canMove(int[] board) {

		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0)
				return true;
		}
		return false;
	}

	

	public static int getIndexOfGoodPosition(int[] board) {
		int res = -1;
		if (board[RomConst.CENTER_OF_THE_BOARD] == 0) {
			return RomConst.CENTER_OF_THE_BOARD;
		} else if (board[RomConst.CORNER_1] == 0) {
			return RomConst.CORNER_1;
		} else if (board[RomConst.CORNER_2] == 0) {
			return RomConst.CORNER_2;
		} else if (board[RomConst.CORNER_3] == 0) {
			return RomConst.CORNER_3;
		} else if (board[RomConst.CORNER_4] == 0) {
			return RomConst.CORNER_4;
		}
		return res;
	}

}
