package medium;

import java.util.*;

public class CourseSchedule {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge : prerequisites) {
			List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
			list.add(edge[1]);
			map.put(edge[0], list);
		}
		Set<Integer> visited = new HashSet<>();
		for (int key : map.keySet()) {
			if (!visited.contains(key)) {
				Set<Integer> path = new HashSet<>();
				path.add(key);
				if (!dfs(map, key, path)) {
					return false;
				}
				visited.addAll(path);
			}
		}
		return true;
	}

	public static boolean dfs(Map<Integer, List<Integer>> map, int key, Set<Integer> path) {
		if (map.containsKey(key)) {
			for (int child : map.get(key)) {
				if (path.contains(child))
					return false;
				path.add(child);
				if (!dfs(map, child, path))
					return false;
				path.remove(child);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] s = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		System.out.println(canFinish(3, s));
	}

}
