package medium;

import java.util.Arrays;

public class Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;
		if (n == 0)
			return false;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
				int result = Arrays.binarySearch(matrix[i], target);
				if (result >= 0)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {{}};
		System.out.println(searchMatrix(matrix, 5));
	}

}
