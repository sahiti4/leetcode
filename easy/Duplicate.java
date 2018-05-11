package easy;

import java.util.*;

public class Duplicate {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (set.contains(i))
				return false;
			set.add(i);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
