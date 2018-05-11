package hard;

public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		int[][] dp = new int[s.length() + 1][p.length() + 1];
		return isMatch(s, p, dp, 0, 0);
	}

	public static boolean isMatch(String s, String p, int[][] dp, int i, int j) {
		if (i == s.length()) {
			while (j < p.length() - 1) {
				if (p.charAt(j + 1) != '*')
					return false;
				j += 2;
			}
			return j == p.length();
		}
		if (j == p.length())
			return false;
		if (dp[i][j] != 0)
			return dp[i][j] == 1;
		if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
			for (int m = i; m < s.length(); m++) {
				if (p.charAt(j) != '.' && s.charAt(m) != p.charAt(j)) {
					dp[i][j] = isMatch(s, p, dp, m, j + 2) ? 1 : -1;
					return dp[i][j] == 1;
				}
				boolean flag1 = isMatch(s, p, dp, m + 1, j);
				boolean flag2 = isMatch(s, p, dp, m, j + 2);
				if (flag1 || flag2) {
					dp[i][j] = 1;
					return true;
				}
			}
		}
		if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
			dp[i][j] = isMatch(s, p, dp, i + 1, j + 1) ? 1 : -1;
			return dp[i][j] == 1;
		}
		dp[i][j] = -1;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("", "c*"));
	}
}
