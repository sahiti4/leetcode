package easy;

import java.util.*;

public class MostCommonWord {

	public static String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Integer> map = new HashMap<>();
		Set<String> bannedSet = new HashSet<>();
		String[] para = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		for (String s : banned) {
			bannedSet.add(s);
		}
		int max = 0;
		String res = "";
		for (String s : para) {
			String sL = s.toLowerCase();
			if (!bannedSet.contains(sL)) {
				int count = map.getOrDefault(sL, 0);
				map.put(sL, count + 1);
				if (count + 1 > max) {
					res = sL;
					max = count + 1;
				}
			}
		}
		return res;

	}

	public static void main(String[] args) {
		String[] banned = {};
		System.out.println(mostCommonWord("a.", banned));
	}
}
