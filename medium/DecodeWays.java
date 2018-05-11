package medium;

import java.util.*;

public class DecodeWays {

	public static int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		if (s.startsWith("0"))
			return 0;
		int[] dp = new int[s.length()];
		Arrays.fill(dp, -1);
		numDecodings(s, 0, dp);
		return dp[0];
	}

	public static int numDecodings(String s, int i, int[] dp) {
		if (i > s.length()) {
			return 0;
		}
		if (i == s.length()) {
			return 1;
		}
		if (s.charAt(i) == '0')
			return 0;
		if (dp[i] != -1)
			return dp[i];
		int result = 0;
		int subR1 = numDecodings(s, i + 1, dp);
		result += subR1;

		if (i + 1 < s.length()) {
			int subR2 = numDecodings(s, i + 2, dp);
			String temp = "" + s.charAt(i) + s.charAt(i + 1);
			int numVal = Integer.valueOf(temp) + 64;
			if (numVal < 91) {
				result += subR2;
			}
		}
		dp[i] = result;
		return dp[i];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("103"));
	}
}
