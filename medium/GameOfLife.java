package medium;

public class GameOfLife {

	public static void gameOfLife(int[][] board) {
		int[][] temp = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				temp[i][j] = board[i][j];
			}
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int neighbour1 = i >= 1 && j >= 1 ? temp[i - 1][j - 1] : 0;
				int neighbour2 = i >= 1 && j < n - 1 ? temp[i - 1][j + 1] : 0;
				int neighbour3 = i >= 1 ? temp[i - 1][j] : 0;
				int neighbour4 = i < m - 1 && j >= 1 ? temp[i + 1][j - 1] : 0;
				int neighbour5 = i < m - 1 && j < n - 1 ? temp[i + 1][j + 1] : 0;
				int neighbour6 = i < m - 1 ? temp[i + 1][j] : 0;
				int neighbour7 = j >= 1 ? temp[i][j - 1] : 0;
				int neighbour8 = j < n - 1 ? temp[i][j + 1] : 0;
				int total = neighbour1 + neighbour2 + neighbour3 + neighbour4 + neighbour5 + neighbour6 + neighbour7
						+ neighbour8;
				if (temp[i][j] == 1) {
					if (total < 2)
						board[i][j] = 0;
					if (total > 3)
						board[i][j] = 0;
				} else {
					if (total == 3)
						board[i][j] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] board = { { 1, 1 }, { 1, 0 } };
		gameOfLife(board);
	}
}
