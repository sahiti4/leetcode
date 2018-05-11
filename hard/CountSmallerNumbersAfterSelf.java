package hard;

import java.util.*;

public class CountSmallerNumbersAfterSelf {

	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		if (nums.length == 0)
			return res;
		if (nums.length >= 1) {
			res.add(0);
			temp.add(nums[nums.length - 1]);
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			int count = insert(temp, nums[i], 0, temp.size() - 1) + 1;
			temp.add(count, nums[i]);
			res.add(0, count);
		}
		return res;
	}

	public static int insert(List<Integer> temp, int target, int left, int right) {
		if (left == right) {
			int curr = temp.get(left);
			if (curr >= target)
				return left - 1;
			return left;
		}
		int mid = (left + right) / 2;
		if (temp.get(mid) >= target)
			return insert(temp, target, 0, mid);
		if (temp.get(mid) < target)
			return insert(temp, target, mid + 1, right);
		return -2;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 2, 1 };
		System.out.println(countSmaller(nums));
	}

}
