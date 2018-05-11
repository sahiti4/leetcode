package easy;

import java.util.*;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			int value = map.getOrDefault(i, 0);
			if (value + 1 > (nums.length / 2.0))
				return i;
			map.put(i, ++value);
		}
		return -1;
	}

}
