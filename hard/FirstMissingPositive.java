package hard;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			while (nums[j] > 0 && nums[j] < nums.length && nums[j] != j + 1 && nums[j] != nums[nums[j] - 1]) {
				swap(nums, j, nums[j] - 1);
			}
		}
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return i + 1;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		System.out.println(firstMissingPositive(nums));
	}

}
