package medium;

import java.util.*;

public class ShuffleArray {

	int[] original;
	Random rand;

	public ShuffleArray(int[] nums) {
		this.original = nums;
		this.rand = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return original;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] nums = original.clone();
		for (int i = 0; i < nums.length ; i++) {
			int j = i + this.rand.nextInt(nums.length - i);
			swap(nums, i, j);
		}
		return nums;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		ShuffleArray obj = new ShuffleArray(arr);
		System.out.println(Arrays.toString(obj.shuffle()));
	}
}
