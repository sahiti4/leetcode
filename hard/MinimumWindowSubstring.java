package hard;

import java.util.*;

public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		int[] charArr = new int[256];
		String res = "";
		int count = 0;
		int[] target = new int[256];
		for (char c : t.toCharArray()) {
			target[(int) c]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (t.indexOf(curr) >= 0) {
				charArr[curr]++;
				queue.add(i);
				if (target[curr] >= charArr[curr])
					count++;
			}
			if (count == t.length()) {
				int start = queue.poll();
				while (charArr[s.charAt(start)] > target[s.charAt(start)]) {
					charArr[s.charAt(start)]--;
					start = queue.poll();
				}
				if (res.equals("") || res.length() > i + 1 - start)
					res = s.substring(start, i + 1);
				charArr[s.charAt(start)]--;
				count--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("AAB", "AB"));
	}
}
