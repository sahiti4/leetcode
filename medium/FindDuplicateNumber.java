package medium;

public class FindDuplicateNumber {

	// public int findDuplicate(int[] nums) {
	// Arrays.sort(nums);
	// for (int i = 1; i < nums.length; i++) {
	// if (nums[i - 1] == nums[i])
	// return nums[i];
	// }
	// return -1;
	// }

	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int sumTh = n * (n - 1) / 2;
		int sum = 0;
		for (int i = 1; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum - sumTh;
	}

	public static void main(String[] args) {

	}

}
