package medium;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
				j++;
				nums[j] = nums[i];
			}
		}
		return j+1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		removeDuplicates(nums);
	}

}
