package medium;

import java.util.*;

public class Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		permute(nums, 0, nums.length - 1, results, new ArrayList<>());
		return results;
	}

	public static void permute(int[] nums, int l, int r, List<List<Integer>> results, List<Integer> result) {
		if (l == r) {
			result.add(nums[r]);
			List<Integer> temp = new ArrayList<>();
			temp.addAll(result);
			results.add(temp);
			result.remove(result.size() - 1);
			return;
		}
		for (int i = l; i <= r; i++) {
			swap(nums, l, i);
			result.add(nums[l]);
			permute(nums, l + 1, r, results, result);
			result.remove(result.size() - 1);
			swap(nums, l, i);
		}

	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(permute(nums));
	}
}
