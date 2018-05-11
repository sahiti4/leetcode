package easy;

import java.util.*;

public class IntersectionofArrays {

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			int value = map.getOrDefault(nums1[i], 0);
			map.put(nums1[i], ++value);
		}
		List<Integer> result = new ArrayList<>();
		for (int i : nums2) {
			int count = map.getOrDefault(i, 0);
			if (count > 0) {
				result.add(i);
				map.put(i, --count);
			}
		}
		int[] out = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			out[i] = result.get(i);
		}
		return out;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1 };
		int[] nums2 = { 1 ,1};
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}

}
