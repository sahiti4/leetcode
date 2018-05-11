package medium;

import java.util.*;

public class Trie {

	Map<String, List<String>> map;
	Map<String, Boolean> exists;

	/** Initialize your data structure here. */
	public Trie() {
		map = new HashMap<>();
		exists = new HashMap<>();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		int i = 1;
		while (i <= word.length()) {
			if (!map.containsKey(word.substring(0, i))) {
				List<String> list = new ArrayList<>();
				String s = "";
				if (i != 1) {
					s = word.substring(0, i - 1);
				}
				list.add(word.substring(0, i));
				map.put(s, list);
				map.put(word.substring(0, i), new ArrayList<>());
			}
			if (i == word.length())
				exists.put(word.substring(0, i), true);
			i++;
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		return map.containsKey(word) && exists.containsKey(word);
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		return map.containsKey(prefix);
	}

}
