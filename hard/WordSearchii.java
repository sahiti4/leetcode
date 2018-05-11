package hard;

import java.util.*;

public class WordSearchii {
	public static List<String> findWords(char[][] board, String[] words) {
		Map<Character, List<String>> map = new HashMap<>();
		Set<String> result = new HashSet<>();
		for (String word : words) {
			List<String> list = map.getOrDefault(word.charAt(0), new ArrayList<>());
			list.add(word);
			map.put(word.charAt(0), list);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (map.containsKey(board[i][j])) {
					List<String> list = map.get(board[i][j]);
					List<String> cloneList = new ArrayList<>();
					cloneList.addAll(list);
					for (String word : cloneList) {
						boolean[][] visited = new boolean[board.length][board[0].length];
						if (search(board, visited, i, j, word, 0)) {
							result.add(word);
							list.remove(word);
						}
					}
				}
			}
		}
		return new ArrayList<>(result);
	}

	public static boolean search(char[][] board, boolean[][] visited, int i, int j, String word, int ind) {
		if (ind == word.length())
			return true;
		if (i < 0 || j < 0 || i == board.length || j == board[0].length)
			return false;
		if (visited[i][j])
			return false;
		if (board[i][j] != word.charAt(ind))
			return false;
		visited[i][j] = true;
		boolean up = search(board, visited, i - 1, j, word, ind + 1);
		boolean down = search(board, visited, i + 1, j, word, ind + 1);
		boolean right = search(board, visited, i, j + 1, word, ind + 1);
		boolean left = search(board, visited, i, j - 1, word, ind + 1);
		visited[i][j] = false;
		return up || down || right || left;
	}

	public static void main(String[] args) {
		char[][] board = { { 'a' } };
		String[] words = { "a" };
		System.out.println(findWords(board, words));
	}
}
