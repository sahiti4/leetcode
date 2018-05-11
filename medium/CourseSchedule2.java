package medium;

import java.util.*;

public class CourseSchedule2 {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer> coursesTaken = new ArrayList<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] pre : prerequisites) {
			List<Integer> list = graph.getOrDefault(pre[0], new ArrayList<>());
			list.add(pre[1]);
			graph.put(pre[0], list);
		}
		int[] result = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			Set<Integer> path = new HashSet<>();
			path.add(i);
			boolean flag = true;
			if (!coursesTaken.contains(i)) {
				dfs(graph, path, coursesTaken, i);
				coursesTaken.add(i);
			}
			if (!flag)
				return result;
		}
		int i = 0;
		for (int course : coursesTaken) {
			result[i++] = course;
		}
		return result;
	}

	public static boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> path, List<Integer> coursesTaken,
			int key) {
		if (graph.containsKey(key)) {
			for (int child : graph.get(key)) {
				if (path.contains(child)) {
					return false;
				}
				if (coursesTaken.contains(child))
					continue;
				path.add(child);
				if (!dfs(graph, path, coursesTaken, child))
					return false;
				coursesTaken.add(child);
				path.remove(child);

			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] prereq = { { 0, 1 }, { 1, 0 } };
		System.out.println(Arrays.toString(findOrder(2, prereq)));
	}

}
