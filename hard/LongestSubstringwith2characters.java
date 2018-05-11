package hard;

import java.util.*;

public class LongestSubstringwith2characters {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int length = 0, i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (i = 0, j = 0; i < s.length() && j < s.length();) {
			char curr = s.charAt(j);
			if (map.containsKey(curr)) {
				int count = map.get(curr);
				map.put(curr, count + 1);
				j++;
				length = Math.max(j - i, length);
			} else if (map.size() < 2) {
				map.put(curr, 1);
				j++;
				length = Math.max(j - i, length);
			} else {
				int count = map.get(s.charAt(i));
				if (count > 1)
					map.put(s.charAt(i), count - 1);
				else {
					map.remove(s.charAt(i));
				}
				i++;
			}
		}
		return Math.max(j - i, length);
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("ea"));
	}
}
