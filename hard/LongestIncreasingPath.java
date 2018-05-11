package hard;

public class LongestIncreasingPath {

	public static int longestIncreasingPath(int[][] matrix) {
		int res = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int val = dfs(matrix, i, j, dp, Integer.MIN_VALUE);
				res = Math.max(res, val);
			}
		}
		return res;
	}

	public static int dfs(int[][] matrix, int i, int j, int[][] dp, int prev) {
		if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length || matrix[i][j] <= prev)
			return 0;
		if (dp[i][j] > 0)
			return dp[i][j];
		else {
			int curr = matrix[i][j];
			int up = dfs(matrix, i - 1, j, dp, curr);
			int down = dfs(matrix, i + 1, j, dp, curr);
			int left = dfs(matrix, i, j - 1, dp, curr);
			int right = dfs(matrix, i, j + 1, dp, curr);
			int max = Math.max(Math.max(up, down), Math.max(right, left));
			dp[i][j] = max + 1;
		}
		return dp[i][j];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		System.out.println(longestIncreasingPath(matrix));
	}

}
