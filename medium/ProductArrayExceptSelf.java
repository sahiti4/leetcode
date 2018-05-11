package medium;

public class ProductArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] tempF = new int[nums.length];
		int[] tempB = new int[nums.length];
		int[] result = new int[nums.length];
		tempF[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			tempF[i] = tempF[i - 1] * nums[i - 1];
		}
		tempB[nums.length - 1] = 1;
		for (int i = nums.length - 1; i > 0; i--) {
			tempB[i - 1] = tempB[i] * nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = tempF[i] * tempB[i];
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
