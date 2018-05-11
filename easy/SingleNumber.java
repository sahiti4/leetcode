package easy;

import java.util.*;

public class SingleNumber {

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> set = new HashMap<>();
		for (int i : nums) {
			int count = set.getOrDefault(i, 0);
			set.put(i, ++count);
		}
		for (int i : set.keySet()) {
			int count= set.get(i);
			if(count==1)
				return i;
		}
		return -1;
	}

}
