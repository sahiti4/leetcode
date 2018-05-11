package medium;

import java.util.*;

public class CustomSortString {

	public static String customSortString(String S, String T) {
		Map<Character, Integer> order = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			order.put(S.charAt(i), i);
		}
		String[] temp = new String[26];
		Arrays.fill(temp, "");
		String result = "";
		for (int i = 0; i < T.length(); i++) {
			char curr = T.charAt(i);
			if (order.containsKey(curr)) {
				int index = order.get(curr);
				temp[index] = temp[index] + curr;
			} else {
				result = result + curr;
			}
		}
		for (String s : temp) {
			result = result+s;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(customSortString("cba", "abcd"));
	}

}
