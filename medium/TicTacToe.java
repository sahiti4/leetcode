package medium;

public class TicTacToe {
	int[][] board = null;
	int n;

	public TicTacToe(int n) {
		board = new int[n][n];
		this.n = n;
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		boolean flag = true;
		board[row][col] = player;
		for (int i = 0; i < n; i++) {
			if (board[i][col] != player) {
				flag = false;
				break;
			}
		}
		if (flag)
			return 1;
		flag = true;
		for (int i = 0; i < n; i++) {
			if (board[row][i] != player) {
				flag = false;
				break;
			}
		}
		if (flag)
			return 1;
		flag = true;
		if (row == col) {
			for (int i = 0; i < n; i++) {
				if (board[i][i] != player) {
					flag = false;
					break;
				}
			}
			if (flag)
				return 1;
		}
		flag = true;
		for (int i = 0; i < n; i++) {
			if (board[n - 1 - i][i] != player) {
				flag = false;
				break;
			}
		}
		if (flag)
			return 1;
		return 0;
	}

	public static void main(String[] args) {
		TicTacToe obj = new TicTacToe(3);
		int param_1 = obj.move(0, 0, 1);
		int param_2 = obj.move(0, 2, 2);
		int param_3 = obj.move(2, 2, 1);
		int param_4 = obj.move(1, 1, 2);
		int param_5 = obj.move(2, 0, 1);
		int param_6 = obj.move(1, 0, 2);
		int param_7 = obj.move(2, 1, 1);
		System.out.println(param_1);
		System.out.println(param_2);
		System.out.println(param_3);
		System.out.println(param_4);
		System.out.println(param_5);
		System.out.println(param_6);
		System.out.println(param_7);
	}
}
