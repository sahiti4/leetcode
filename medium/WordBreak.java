package medium;

import java.util.*;

public class WordBreak {

	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>();
		dict.addAll(wordDict);
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> stack = new LinkedList<>();
		stack.add(0);
		while (!stack.isEmpty()) {
			int curr = stack.poll();
			for (int i = curr + 1; i <= s.length(); i++) {
				if (wordDict.contains(s.substring(curr, i))) {
					if (!visited.contains(curr))
						stack.add(i);
					if (i == s.length())
						return true;
				}
			}
			visited.add(curr);
		}
		return false;
	}

	public static boolean wordbreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length()];
		Set<String> dict = new HashSet<>(wordDict);
		for (int i = s.length() - 1; i >= 0; i--) {
			if (dict.contains(s.substring(i, s.length()))) {
				dp[i] = true;
				continue;
			} else {
				for (int j = i + 1; j < s.length(); j++) {
					if (dp[j] && dict.contains(s.substring(i, j))) {
						dp[i] = true;
						break;
					}
				}
			}

		}
		return dp[0];
	}

	public static void main(String[] args) {
		List<String> dict = new ArrayList<>();
		dict.add("apple");
		dict.add("pen");
		System.out.println(wordbreak("applepenapple", dict));
	}
}
