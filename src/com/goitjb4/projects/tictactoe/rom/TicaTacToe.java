
public abstract class TicaTacToe {
	
	
	abstract int move(int player, int[] board);

	public static void clearTheBoard(int[] board) {
		for (int i = 0; i < board.length; i++) {
			board[i] = 0;
		}
	}
	


}
