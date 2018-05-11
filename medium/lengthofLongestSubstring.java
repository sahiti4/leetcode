package medium;

import java.util.*;

public class lengthofLongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		int length = 0;
		int i = 0, j = 0;
		Set<Character> set = new HashSet<>();
		while (i < s.length() && j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				length = Math.max(length, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return length;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcd"));
	}
}
