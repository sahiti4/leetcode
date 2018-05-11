package medium;

import java.util.*;

public class NextPermutation {

	public static void nextPermutation(int[] nums) {
		if (nums.length <= 1)
			return;
		TreeSet<Integer> set = new TreeSet<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		int i = nums.length - 1;
		for (; i >= 0; i--) {
			if (set.higher(nums[i]) != null) {
				int temp = nums[i];
				int ind = map.get(set.higher(nums[i])).get(0);
				nums[i] = set.higher(nums[i]);
				nums[ind] = temp;
				break;
			}
			set.add(nums[i]);
			List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
			list.add(i);
			map.put(nums[i], list);
		}
		i++;
		Arrays.sort(nums, i, nums.length);
		return;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1 };
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

}
