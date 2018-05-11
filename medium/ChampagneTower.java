package medium;

import java.util.*;

public class ChampagneTower {

	public static double champagneTower(int poured, int query_row, int query_glass) {
		double[][] dp = new double[101][101];
		if (poured >= 1) {
			dp[1][1] = poured;
		}
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j <= i; j++) {
				if (dp[i][j] > 1) {
					dp[i + 1][j] += (dp[i][j] - 1) / 2;
					dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
					if (dp[i][j] - 1 > 1)
						dp[i][j] = 1.00;
					else {
						dp[i][j]--;
					}
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[query_row + 1][query_glass + 1];
	}

	public static void main(String[] args) {
		champagneTower(4, 1, 0);
	}
}
