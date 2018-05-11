package easy;

public class LargestArea {

	public static double largestTriangleArea(int[][] points) {
		double max = 0.00;
		for (int i = 0; i < points.length - 2; i++) {
			int[] p1 = points[i];
			for (int j = i + 1; j < points.length - 1; j++) {
				int[] p2 = points[j];
				double area = 0.5;
				for (int k = j + 1; k < points.length; k++) {
					int[] p3 = points[k];
					int num = (p1[0] - p2[0]) * (p3[1] - p1[1]) - (p1[1] - p2[1]) * (p3[0] - p1[0]);
					area = Math.abs(num) * area;
					max = Math.max(area, max);
					area = 0.5;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] points = { { 8, 10 }, { 2, 7 }, { 9, 2 }, { 4, 10 } };
		largestTriangleArea(points);
	}

}
