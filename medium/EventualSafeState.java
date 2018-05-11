package medium;

import java.util.*;

public class EventualSafeState {

	public List<Integer> eventualSafeNodes(int[][] graph) {
		int n = graph.length;
		int[] flag = new int[n];
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Set<Integer> path = new HashSet<>();
			path.add(i);
			if (dfs(graph, i, path, flag)) {
				result.add(i);
			}
		}
		return result;
	}

	public boolean dfs(int[][] graph, int root, Set<Integer> path, int[] flag) {
		if (flag[root] != 0)
			return flag[root] > 0;
		int[] children = graph[root];
		flag[root] = -1;
		for (int child : children) {
			if (flag[child] == 1)
				continue;
			if (path.contains(child))
				return false;
			path.add(child);
			if (flag[child] == -1 || !dfs(graph, child, path, flag)) {
				return false;
			}
			path.remove(child);
		}
		flag[root] = 1;
		return true;
	}

}
