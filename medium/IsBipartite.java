package medium;

import java.util.*;

public class IsBipartite {

	 public static boolean isBipartite(int[][] graph) {
			Set<Integer> a = new HashSet<>();
			Set<Integer> b = new HashSet<>();
			for (int j = 0; j < graph.length; j++) {
				if (!(a.contains(j) || b.contains(j)))
					a.add(j);
				if (a.contains(j)) {
					for (int i : graph[j]) {
						if (a.contains(i))
							return false;
						b.add(i);
					}
				} else if (b.contains(j)) {
					for (int i : graph[j]) {
						if (b.contains(i))
							return false;
						a.add(i);
					}
				}
			}
			return true;
		}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		System.out.println(isBipartite(graph));

	}

}
