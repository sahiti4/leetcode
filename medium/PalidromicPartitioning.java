package medium;

import java.util.*;

public class PalidromicPartitioning {

	public static List<List<String>> partition(String s) {
		return partition(s, 0, s.length() - 1);
	}

	public static List<List<String>> partition(String s, int i, int j) {
		List<List<String>> results = new ArrayList<>();
		if (i > j) {
			results.add(new ArrayList<>());
			return results;
		}
		if (i == j) {
			List<String> list = new ArrayList<>();
			list.add(s.charAt(i) + "");
			results.add(list);
			return results;
		}
		for (int m = i; m <= j; m++) {
			if (isPalindrome(s, i, m)) {
				List<List<String>> subResults = partition(s, m + 1, j);
				for (List<String> subResult : subResults) {
					subResult.add(0, s.substring(i, m + 1));
					results.add(subResult);
				}
			}
		}
		return results;
	}

	public static boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(partition("bb"));
	}
}
