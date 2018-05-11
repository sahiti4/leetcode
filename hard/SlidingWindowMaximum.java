package hard;

import java.util.*;

public class SlidingWindowMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0)
			return new int[0];
		int[] res = new int[nums.length - k + 1];
		int j = 0;
		Deque<Integer> deq = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			while (!deq.isEmpty() && nums[deq.peekFirst()] <= nums[i]) {
				deq.pollFirst();
			}
			deq.offerFirst(i);
		}
		res[j++] = nums[deq.peekLast()];
		for (int i = k; i < nums.length; i++) {
			if (!deq.isEmpty() && deq.peekLast() < i - k + 1)
				deq.pollLast();
			while (!deq.isEmpty() && nums[deq.peekFirst()] <= nums[i]) {
				deq.pollFirst();
			}
			deq.offerFirst(i);
			res[j++] = nums[deq.peekLast()];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1 };
		System.out.println(Arrays.toString(maxSlidingWindow(nums, 1)));
	}

}
