package medium;

public class LargestSumOfAvgs {

	public static double largestSumOfAverages(int[] A, int K) {
		double[][] dp = new double[A.length + 1][K + 1];
		largestSumOfAverages(A, dp, K, 0);
		return dp[A.length][K];
	}

	public static double largestSumOfAverages(int[] A, double[][] dp, int k, int i) {
		if (k == 1) {
			int sum = 0;
			int count = 0;
			while (i < A.length) {
				sum += A[i];
				count++;
				i++;
			}
			dp[i][1] = 1.00 * sum / (count);
			return dp[i][1];
		}
		if (dp[i][k] != 0)
			return dp[i][k];
		int sum = 0;
		double max = 0.00;
		for (int j = i; j < A.length - k + 1; j++) {
			double avg = 1.00 * (sum + A[j]) / (j - i + 1);
			sum = sum + A[j];
			double subMax = largestSumOfAverages(A, dp, k - 1, j + 1);
			max = Math.max(max, subMax + avg);
		}
		dp[i][k] = max;
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 9, 1, 2, 3, 9 };
		System.out.println(largestSumOfAverages(nums, 3));
	}

}
