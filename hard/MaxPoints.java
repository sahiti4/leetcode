package hard;

import java.util.*;

public class MaxPoints {

	public static int maxPoints(Point[] points) {
		int result = 0;
		if (points.length < 2)
			return points.length;
		for (int i = 0; i < points.length - 1; i++) {
			Map<Double, Integer> map = new HashMap<>();
			Point p1 = points[i];
			int rep = 0;
			int max = 0;
			for (int j = i + 1; j < points.length; j++) {
				double slope = 0.00;
				Point p2 = points[j];
				if (p1.x == p2.x && p1.y == p2.y) {
					rep++;
				} else if (p1.x == p2.x) {
					int count = map.getOrDefault(Double.MAX_VALUE, 1);
					map.put(Double.MAX_VALUE, ++count);
					max = Math.max(count, max);
				} else {
					slope = 1.00 * (p2.y - p1.y) / (p2.x - p1.x);
					if (slope == -0.00)
						slope = 0.00;
					int count = map.getOrDefault(slope, 1);
					map.put(slope, ++count);
					max = Math.max(count, max);
				}

			}
			max = max == 0 ? rep + 1 : max + rep;
			result = Math.max(result, max);
		}
		return result;
	}

	public static void main(String[] args) {
		Point[] arr = { new Point(1, 1), new Point(1, 1) };
		System.out.println(maxPoints(arr));
	}

}

class Line {
	double m;
	double c;
	int x;

	Line(double m, double c) {
		this.m = m;
		this.c = c;
		this.x = 0;
	}

	Line(int x) {
		this.x = x;
		this.m = Double.MAX_VALUE;
	}

}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
