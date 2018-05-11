package easy;

public class HouseRobber {
	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		if (n == 2)
			return Math.max(nums[0], nums[1]);
		int[] dp = new int[n];
		int maxEven = 0;
		int maxOdd = 0;
		dp[n - 1] = nums[n - 1];
		dp[n - 2] = nums[n - 2];
		if ((n - 1) % 2 == 0) {
			maxEven = nums[n - 1];
			maxOdd = nums[n - 2];
		} else {
			maxOdd = nums[n - 1];
			maxEven = nums[n - 2];
		}
		for (int i = n - 3; i >= 0; i--) {
			if (i % 2 == 0) {
				if (maxOdd != dp[i + 1]) {
					maxEven = Math.max(maxOdd, maxEven) + nums[i];
				} else {
					maxEven = Math.max(maxOdd - nums[i + 1], maxEven) + nums[i];
				}
				dp[i] = maxEven;
			} else {
				if (maxEven != dp[i + 1]) {
					maxOdd = Math.max(maxOdd, maxEven) + nums[i];
				} else {
					maxOdd = Math.max(maxEven - nums[i + 1], maxOdd) + nums[i];
				}
				dp[i] = maxOdd;
			}
		}
		return Math.max(maxEven, maxOdd);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		rob(nums);
	}
}
