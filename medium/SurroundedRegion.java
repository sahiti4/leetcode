package medium;

public class SurroundedRegion {

	public static void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					solve(board, i, j);
				}
			}
		}
	}

	public static int solve(char[][] board, int i, int j) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length)
			return -1;
		if (board[i][j] == 'X')
			return 1;
		if (board[i][j] == 'V')
			return 0;
		if (board[i][j] == 'O') {
			board[i][j] = 'V';
			int up = solve(board, i + 1, j);
			int down = solve(board, i - 1, j);
			int left = solve(board, i, j - 1);
			int right = solve(board, i, j + 1);
			if (up != -1 && down != -1 && left != -1 && right != -1) {
				board[i][j] = 'X';
				return 1;
			}
			board[i][j] = 'O';
		}
		return -1;
	}

	public static void print(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(board);
		print(board);
	}

}
