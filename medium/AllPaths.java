package medium;

import java.util.*;

public class AllPaths {
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		dfs(graph, 0, path, results);
		return results;
	}

	public static void dfs(int[][] graph, int root, List<Integer> path, List<List<Integer>> results) {
		if (root == graph.length - 1) {
			List<Integer> result = new ArrayList<>();
			result.addAll(path);
			results.add(result);
			return;
		}

		if (graph[root].length == 0) {
			return;
		}
		for (int child : graph[root]) {
			path.add(child);
			dfs(graph, child, path, results);
			path.remove(path.size() - 1);
		}
		return;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		System.out.println(allPathsSourceTarget(graph));
	}

}
