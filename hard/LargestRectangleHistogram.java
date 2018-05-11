package hard;

import java.util.*;

public class LargestRectangleHistogram {

	public static int largestRectangleArea(int[] heights) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		stack.add(-1);
		int i = 0;
		for (i = 0; i < heights.length; i++) {
			while (stack.peek() >= 0 && heights[i] < heights[stack.peek()]) {
				int pop = stack.pop();
				res = Math.max(res, (i - 1 - stack.peek()) * heights[pop]);
			}
			stack.push(i);
		}
		while (stack.peek() >= 0) {
			int pop = stack.pop();
			res = Math.max(res, (i - 1 - stack.peek()) * heights[pop]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 0, 2 };
		System.out.println(largestRectangleArea(arr));
	}

}
