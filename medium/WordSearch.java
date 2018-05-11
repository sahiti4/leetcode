package medium;

import java.util.Arrays;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		int[][] dp = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (exist(board, i, j, 0, word, dp))
						return true;
				}
			}
		}
		return false;
	}

	public static boolean exist(char[][] board, int i, int j, int m, String word, int[][] dp) {
		if (m > word.length() - 1)
			return true;
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
			return false;
		if (word.charAt(m) != board[i][j] || dp[i][j] == 0)
			return false;

		dp[i][j] = 0;
		boolean right = exist(board, i + 1, j, m + 1, word, dp);
		boolean left = exist(board, i - 1, j, m + 1, word, dp);
		boolean down = exist(board, i, j - 1, m + 1, word, dp);
		boolean up = exist(board, i, j + 1, m + 1, word, dp);
		if (right || left || up || down)
			return true;
		dp[i][j] = -1;
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "SEE"));
	}

}
