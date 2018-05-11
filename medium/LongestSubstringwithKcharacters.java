package medium;

import java.util.*;

public class LongestSubstringwithKcharacters {

	public static int longestSubstring(String s, int k) {
		return longestSubstring(s, 0, s.length(), k);
	}

	public static int longestSubstring(String s, int m, int n, int k) {
		int[] countchar = new int[26];
		int result = 0;
		for (int i = m; i < n; i++) {
			countchar[s.charAt(i) - 'a']++;
		}
		Set<Integer> list = new HashSet<>();
		for (int i = 0; i < 26; i++) {
			if (countchar[i] < k && countchar[i] != 0)
				list.add(i);
		}
		if (list.isEmpty())
			return n - m;
		for (int i = m; i < n; i++) {
			int initial = i;
			while (i < n && !list.contains(s.charAt(i) - 'a')) {
				i++;
			}
			if (i > initial)
				result = Math.max(result, longestSubstring(s, initial, i, k));
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("aaabb", 3));
	}
}
