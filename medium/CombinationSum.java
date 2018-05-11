package medium;

import java.util.*;

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, new ArrayList<Integer>(), results);
		return results;
	}

	public static void combinationSum(int[] candidates, int target, int i, List<Integer> result,
			List<List<Integer>> results) {
		if (target < 0)
			return;
		if (target == 0) {
			List<Integer> res = new ArrayList<>();
			res.addAll(result);
			results.add(res);
			return;
		}
		if (i == candidates.length) {
			return;
		}
		for (int j = 0; j < 1 + (target / candidates[i]); j++) {
			int temp = j;
			while (temp > 0) {
				result.add(candidates[i]);
				temp--;
			}
			combinationSum(candidates, target - j * candidates[i], i + 1, result, results);
			temp = j;
			while (temp > 0) {
				result.remove(result.size() - 1);
				temp--;
			}
		}
		return;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 3, 5 };
		int target = 8;
		System.out.println(combinationSum(nums, target));
	}

}
