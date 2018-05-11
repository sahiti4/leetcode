package medium;

import java.util.*;

public class TopKfrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int count = map.getOrDefault(num, 0);
			map.put(num, ++count);
		}
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] elementFreq = (ArrayList<Integer>[]) new ArrayList[nums.length + 1];
		for (int key : map.keySet()) {
			int value = map.get(key);
			ArrayList<Integer> temp = elementFreq[value] != null ? elementFreq[value] : new ArrayList<>();
			temp.add(key);
			elementFreq[value] = temp;
		}
		List<Integer> result = new ArrayList<>();
		int i = nums.length;
		while (result.size() < k && i > 0) {
			if (elementFreq[i] != null)
				result.addAll(elementFreq[i]);
			i--;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		System.out.println(topKFrequent(nums, 2));
	}

}
