package medium;

import java.util.*;

public class LongestSubString {

	public static int longestSubstring(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			int count = map.getOrDefault(currChar, 0);
			map.put(s.charAt(i), ++count);
		}
		int length = 0;
		int previous = 0;
		int i = 0;
		for (i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			int count = map.get(curr);
			if (count < k) {
				length = Math.max(length, lengthFind(s.substring(previous, i), k));
				previous = i + 1;
			}
		}
		if (previous == 0 && (i == s.length()))
			return s.length();

		return length;
	}

	public static int lengthFind(String s, int k) {
		Map<Character, Integer> temp = new HashMap<>();
		for (char c : s.toCharArray()) {
			int count = temp.getOrDefault(c, 0);
			temp.put(c, ++count);
		}
		boolean flag = true;
		for (char key : temp.keySet()) {
			if (temp.get(key) < k) {
				flag = false;
				break;
			}
		}
		if (flag)
			return s.length();
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("bbaaacbd", 3));

	}

}
