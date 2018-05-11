package medium;

public class LongestIncrSubsequence {

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int max = 0;
		dp[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			int temp = 0;
			for (int j = i; j < n; j++) {
				if (nums[j] > nums[i])
					temp = Math.max(temp, dp[j]);
			}
			dp[i] = temp + 1;
			max = Math.max(dp[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums));
	}

}
