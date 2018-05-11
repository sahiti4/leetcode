package medium;

public class Rotate {

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - i - 1][n - 1 - j] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
	}

}
