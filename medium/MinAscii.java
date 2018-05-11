package medium;


public class MinAscii {
	public static int minimumDeleteSum(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= s1.length(); i++) {
			dp[i][0] = dp[i - 1][0] + (int) s1.charAt(i - 1);
		}
		for (int i = 1; i <= s2.length(); i++) {
			dp[0][i] = dp[0][i - 1] + (int) s2.charAt(i - 1);
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = Math.min(dp[i - 1][j - 1],
							Math.min(dp[i - 1][j] + (int) s1.charAt(i - 1), dp[i][j - 1] + (int) s2.charAt(j - 1)));
				else
					dp[i][j] = Math.min(
							Math.min(dp[i - 1][j] + (int) s1.charAt(i - 1), dp[i][j - 1] + (int) s2.charAt(j - 1)),
							dp[i - 1][j - 1] + (int) s1.charAt(i - 1) + (int) s2.charAt(j - 1));

			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		System.out.println(minimumDeleteSum("delete", "leet"));
	}
}
