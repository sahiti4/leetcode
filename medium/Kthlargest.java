package medium;

import java.util.Arrays;

public class Kthlargest {

	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public static void main(String[] args) {
		
	}

}
