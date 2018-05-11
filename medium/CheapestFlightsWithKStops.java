package medium;

import java.util.*;

public class CheapestFlightsWithKStops {

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[src] = 0;
		Map<String, Integer> edgeWeigh = new HashMap<>();
		Map<Integer, List<Integer>> edges = new HashMap<>();
		for (int[] edge : flights) {
			edgeWeigh.put(edge[0] + "~" + edge[1], edge[2]);
			List<Integer> list = edges.getOrDefault(edge[0], new ArrayList<>());
			list.add(edge[1]);
			edges.put(edge[0], list);
		}
		Queue<Integer> queue = new LinkedList<>();
		// Set<Integer> visited = new HashSet<Integer>();
		queue.add(src);
		int hop = -1;
		int min = Integer.MAX_VALUE;
		while (hop < K) {
			int intial = queue.size();
			int count = 0;
			while (count < intial) {
				int curr = queue.poll();
				count++;
				if (edges.containsKey(curr)) {
					for (int i : edges.get(curr)) {
						if (dp[i] > dp[curr] + edgeWeigh.get(curr + "~" + i)) {
							queue.add(i);
							dp[i] = dp[curr] + edgeWeigh.get(curr + "~" + i);
						}
						if (i == dst)
							min = Math.min(min, dp[i]);
					}
				}
			}
			hop++;
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public static void main(String[] args) {

		findCheapestPrice(10, null, 0, 0, 1);
	}

}
