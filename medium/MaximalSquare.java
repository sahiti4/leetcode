package medium;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		int res = 0;
		int m = matrix.length;
		if (matrix.length == 0)
			return 0;
		int n = matrix[0].length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]);
					res = Math.max(res, dp[i + 1][j + 1] * dp[i + 1][j + 1]);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1',
		// '1', '1' }, { '1', '1', '1', '1', '1' },
		// { '1', '0', '0', '1', '0' } };
		char[][] matrix = {};
		MaximalSquare obj = new MaximalSquare();
		System.out.println(obj.maximalSquare(matrix));
	}
}
