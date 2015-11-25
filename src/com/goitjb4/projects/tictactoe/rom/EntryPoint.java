public class EntryPoint {

	public static void NextMove(int player, int[] board, TicaTacToe ticTacImpls) {
		int[] param = board.clone();

		int resIndex;

		resIndex = ticTacImpls.move(player, param);
		if ((resIndex >= 0) && (board[resIndex] == 0)) {
			board[resIndex] = player;
			RomUtils.ShowTheBoard(board);
		}

	}

	public static void main(String[] args) {

		int[] board = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		TicaTacToe t = new TicaTacRom();

		int counter = 0;
		int player;

		while (RomUtils.canMove(board)) {
			++counter;
			if (counter % 2 == 0) {
				player = -1;
			} else {
				player = 1;
			}
			NextMove(player, board, t);

		}

	}
}
