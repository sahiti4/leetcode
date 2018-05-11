package medium;

public class FindMinimum {

	public static int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			if (start == end)
				return nums[start];
			int mid = (start + end) / 2;
			boolean first = nums[start] < nums[mid] || (start == mid) ? true : false;
			boolean second = nums[mid + 1] < nums[end] || (mid + 1 == end) ? true : false;
			if (first && second)
				return Math.min(nums[start], nums[mid + 1]);
			if (first)
				start = mid + 1;
			if (second)
				end = mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1 };
		System.out.println(findMin(nums));
	}
}
