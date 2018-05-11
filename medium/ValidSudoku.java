package medium;

import java.util.Arrays;

public class ValidSudoku {

	public static boolean isValidSudoku(String[][] board) {
		String[][] checker = new String[9][9];
		for (int i = 0; i < checker.length; i++) {
			Arrays.fill(checker[i], "");
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != ".") {
					if (checker[i][j].indexOf(board[i][j]) >= 0) {
						return false;
					}
					for (int m = 0; m < 9; m++) {
						checker[i][m] += board[i][j];
					}
					for (int m = 0; m < 9; m++) {
						checker[m][j] += board[i][j];
					}
					int row = (i / 3) * 3;
					int col = (j / 3) * 3;
					for (int m = row; m < row + 3; m++) {
						for (int n = col; n < col + 3; n++) {
							checker[m][n] += board[i][j];
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[][] board = { { ".", ".", ".", ".", ".", "3", "2", ".", "4" },
				{ ".", ".", ".", ".", "2", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", "6", ".", ".", ".", ".", "7", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", ".", "." },
				{ ".", ".", ".", ".", "9", ".", ".", ".", "." }, { "3", ".", ".", "1", ".", ".", ".", "8", "." },
				{ ".", ".", ".", ".", ".", ".", ".", ".", "." }, { ".", ".", ".", ".", ".", ".", ".", ".", "." } };
		System.out.println(isValidSudoku(board));
	}

}
