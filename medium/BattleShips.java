package medium;

public class BattleShips {

	public static int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					count++;
					int row = i + 1;
					int column = j + 1;
					while (row < board.length && board[row][j] == 'X') {
						board[row][j] = 'M';
						row++;
					}
					while (column < board[0].length && board[i][column] == 'X') {
						board[i][column] = 'M';
						column++;
					}
					board[i][j] = 'M';
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'X', 'X' } };
		System.out.println(countBattleships(board));
	}

}
