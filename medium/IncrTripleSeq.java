package medium;

public class IncrTripleSeq {

	public static boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		for (int i : nums) {
			if (i <= small)
				small = i;
			else if (i <= second)
				second = i;
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 4, 3, 2, 1 };
		System.out.println(increasingTriplet(nums));
	}
}
