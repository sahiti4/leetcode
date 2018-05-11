package medium;

import java.util.*;

public class PermWithDuplicates {

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		return permuteUnique(nums, new ArrayList<>(), set, 0, nums.length - 1);

	}

	public static List<List<Integer>> permuteUnique(int[] nums, List<Integer> result, Set<Integer> unique, int l,
			int r) {
		List<List<Integer>> results = new ArrayList<>();
		if (l == r) {
			List<Integer> temp = new ArrayList<>();
			temp.addAll(result);
			temp.add(nums[l]);
			results.add(temp);
			return results;
		}
		Set<Integer> set = new HashSet<>();
		set.addAll(unique);
		for (int i = l; i <= r; i++) {
			if (set.contains(nums[i])) {
				swap(nums, l, i);
				result.add(nums[l]);
				List<List<Integer>> subresults = permuteUnique(nums, result, unique, l + 1, r);
				result.remove(result.size() - 1);
				swap(nums, l, i);
				results.addAll(subresults);
				set.remove(nums[i]);
			}
		}
		return results;

	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(permuteUnique(nums));
	}
}
