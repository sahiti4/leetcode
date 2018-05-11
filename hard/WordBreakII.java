package hard;

import java.util.*;

public class WordBreakII {
	public static List<String> wordBreak(String s, List<String> wordDict) {
		Map<Integer, List<String>> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("");
		map.put(s.length() - 1, list);
		List<String> res = wordBreak(s, map, new HashSet<>(wordDict), 0, 0);
		return res != null ? res : new ArrayList<>();
	}

	public static List<String> wordBreak(String s, Map<Integer, List<String>> map, Set<String> set, int i, int j) {
		List<String> result = new ArrayList<>();
		if (j == s.length()) {
			if (i == s.length()) {
				result.add("");
				return result;
			}
			return null;
		}
		if (map.containsKey(i))
			return map.get(i);
		if (set.contains(s.substring(i, j + 1))) {
			List<String> sub = wordBreak(s, map, set, j + 1, j + 1);
			if (sub != null) {
				for (String subS : sub) {
					if (!subS.equals(""))
						result.add(s.substring(i, j + 1) + " " + subS);
					else
						result.add(s.substring(i, j + 1));
				}
			}
		}
		List<String> temp = wordBreak(s, map, set, i, j + 1);
		if (temp != null)
			result.addAll(temp);
		List<String> res = new ArrayList<String>();
		res.addAll(result);
		map.put(i, res);
		return result;
	}

	public static void main(String[] args) {
		String s = "a";
		List<String> list = new ArrayList<>();
		System.out.println(wordBreak(s, list));
	}
}
