package medium;

public class SearchRotatedArray {

	public static int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			if (start == end) {
				if (nums[start] == target)
					return start;
				else {
					return -1;
				}
			} else {
				int mid = (start + end) / 2;
				if (nums[start] < nums[mid]) {
					if (nums[start] <= target && nums[mid] >= target)
						end = mid;
					else {
						start = mid + 1;
					}
				} else {
					if (nums[mid + 1] <= target && nums[end] >= target)
						start = mid + 1;
					else {
						end = mid;
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3 };
		System.out.println(search(nums, 3));
	}

}
