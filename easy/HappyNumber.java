package easy;

import java.util.*;

public class HappyNumber {

	public boolean isHappy(int n) {
		int temp = 0;
		Set<Integer> set = new HashSet<>();
		while (n != 1) {
			String s = Integer.toString(n);
			temp = 0;
			for (char c : s.toCharArray()) {
				int charVal = Character.getNumericValue(c);
				temp += (charVal * charVal);
			}
			n = temp;
			if (n != 1 && set.contains(n))
				return false;
			set.add(n);
		}
		return true;
	}
}
