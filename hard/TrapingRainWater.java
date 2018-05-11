package hard;

import java.util.*;

public class TrapingRainWater {

	public static int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				int base = stack.pop();
				while (!stack.isEmpty()) {
					int left = stack.pop();
					if (height[left] > height[i]) {
						result += (i - left - 1) * (height[i] - height[base]);
						base = left;
						break;
					} else {
						result += (i - left - 1) * (height[left] - height[base]);
						base = left;
					}
				}
				if (height[base] > height[i])
					stack.push(base);
				else
					stack.push(i);
			}
			stack.push(i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] height = { 1,0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
	}

}
