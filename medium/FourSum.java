package medium;

import java.util.*;

public class FourSum {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = A[i] + B[j];
				int temp = map.getOrDefault(sum, 0);
				map.put(sum, temp + 1);
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = -(C[i] + D[j]);
				if (map.containsKey(sum))
					result += map.get(sum);
			}
		}
		return result;
	}

	public static void main(String[] args) {
	}
}
