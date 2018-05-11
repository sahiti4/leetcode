package medium;

import java.util.Arrays;

public class WiggleSort {

	public static void wiggleSort(int[] nums) {
		int n = nums.length;
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = nums[i];
		}
		Arrays.sort(temp);
		if (nums.length < 2)
			return;
		int first = (nums.length - 1) / 2;
		for (int i = first, j = 0; i >= 0; j += 2, i--) {
			nums[j] = temp[i];
		}

		for (int i = n - 1, j = 1; i >= first + 1; j += 2, i--) {
			nums[j] = temp[i];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 1, 1, 6, 4 };
		wiggleSort(nums);
	}

}
