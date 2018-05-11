package hard;

public class DungeonGame {

	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];
		int x = m - 2;
		dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : (dungeon[m - 1][n - 1] * -1) + 1;
		while (x >= 0) {
			if (dungeon[x][n - 1] <= 0) {
				dp[x][n - 1] = -1 * dungeon[x][n - 1] + dp[x + 1][n - 1];
			} else {
				dp[x][n - 1] = dp[x + 1][n - 1] - dungeon[x][n - 1] > 0 ? dp[x + 1][n - 1] - dungeon[x][n - 1] : 1;
			}
			x--;
		}
		x = n - 2;
		while (x >= 0) {
			if (dungeon[m - 1][x] <= 0) {
				dp[m - 1][x] = -1 * dungeon[m - 1][x] + dp[m - 1][x + 1];
			} else {
				dp[m - 1][x] = dp[m - 1][x + 1] - dungeon[m - 1][x] > 0 ? dp[m - 1][x + 1] - dungeon[m - 1][x] : 1;
			}
			x--;
		}
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (dungeon[i][j] <= 0) {
					dp[i][j] = -1 * dungeon[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
				} else {
					dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j] > 0
							? Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j] : 1;
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		calculateMinimumHP(dungeon);
	}

}
