package medium;

import java.util.*;

public class KthSmallestNumber {

	public int kthSmallest(int[][] matrix, int k) {
		int[] temp = new int[matrix.length * matrix.length];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				temp[count++] = matrix[i][j];
			}
		}
		Arrays.sort(temp);
		return temp[k - 1];
	}

	public static void main(String[] args) {

	}

}
