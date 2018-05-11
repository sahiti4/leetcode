package medium;

import java.util.*;

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int level = 2;
		Set<String> wordSet = new HashSet<>();
		wordSet.addAll(wordList);
		wordSet.add(endWord);
		Set<String> visited = new HashSet<>();
		Map<String, List<String>> map = new HashMap<>();
		int count = 1;
		while (!queue.isEmpty()) {
			String word = queue.poll();
			count--;
			List<String> children = null;
			if (!map.containsKey(word)) {
				children = buildGraph(word, wordSet);
				map.put(word, children);
				for (String child : children) {
					if (child.equals(endWord))
						return level;
					if (!visited.contains(child))
						queue.add(child);
				}
			}
			visited.add(word);
			if (count == 0) {
				count += queue.size();
				level++;
			}
		}
		return 0;
	}

	public static List<String> buildGraph(String word, Set<String> wordList) {
		StringBuilder sb = new StringBuilder();
		List<String> children = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			for (int j = 97; j < 123; j++) {
				sb.append(word.substring(0, i));
				sb.append((char) j);
				sb.append(word.substring(i + 1));
				if (wordList.contains(sb.toString()))
					children.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		return children;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		System.out.println(ladderLength("hit", "cog", list));
	}

}
