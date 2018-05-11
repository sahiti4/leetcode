package medium;

public class LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}
		return longestPalidromeSubseq(s, 0, s.length() - 1, dp);

	}

	public int longestPalidromeSubseq(String s, int i, int j, int[][] dp) {
		if (i > j)
			return 0;
		if (i == j)
			return dp[i][j];
		if (dp[i][j] == 0) {
			dp[i][j] = Math.max(longestPalidromeSubseq(s, i + 1, j, dp), longestPalidromeSubseq(s, i, j - 1, dp));
		}
		return dp[i][j];
	}
	

}
