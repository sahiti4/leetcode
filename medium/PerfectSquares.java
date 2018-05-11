package medium;

public class PerfectSquares {

	public int numSquares(int n) {
		int[] dp = new int[n];
		dp[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			int temp = dp[i - 1] + 1;
			int j = 1;
			while (j <= i && i - (j * j) >= 0) {
				temp = Math.min(dp[i - j * j] + 1, temp);
				j++;
			}
			dp[i] = temp;
		}
		return dp[n];
	}

	public static void main(String[] args) {

	}

}
