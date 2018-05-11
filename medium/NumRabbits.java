package medium;

import java.util.*;

public class NumRabbits {

	public static int numRabbits(int[] answers) {
		if (answers.length == 0)
			return 0;
		Map<Integer, Integer> set = new HashMap<>();
		int result = 0;
		for (int n : answers) {
			int count = set.getOrDefault(n, 0);
			set.put(n, count + 1);
		}
		for (int n : set.keySet()) {
			int count = set.get(n);
			int temp = count % (n + 1);
			count = count / (n + 1);
			result += (count) * (1 + n);
			result += temp > 0 ? (1 + n) : 0;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1,1,0,0 };
		System.out.println(numRabbits(arr));
	}
}
