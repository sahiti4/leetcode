package medium;

import java.util.*;

public class LargestNumber {

	public static String largestNumber(int[] nums) {
		String result = "";
		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s = Integer.toString(o1) + Integer.toString(o2);
				String r = Integer.toString(o2) + Integer.toString(o1);
				return s.compareTo(r);
			}
		};
		Integer[] obj = new Integer[nums.length];
		int m = 0;
		for (int i : nums) {
			obj[m++] = i;
		}
		Arrays.sort(obj, comp);
		boolean flag = true;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (obj[i] != 0)
				flag = false;
			result = result + obj[i];
		}
		if (flag)
			return "0";
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0 };
		System.out.println(largestNumber(nums));
	}
}
