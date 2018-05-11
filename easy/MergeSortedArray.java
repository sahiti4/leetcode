package easy;

import java.util.Arrays;

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m + n - 1;
		int j = m - 1;
		int k = n - 1;
		while (i >= 0) {
			while (j >= 0 && k >= 0) {
				if (nums1[j] >= nums2[k]) {
					nums1[i--] = nums1[j--];
				} else {
					nums1[i--] = nums2[k--];
				}
			}
			while (j >= 0) {
				nums1[i--] = nums1[j--];
			}
			while (k >= 0) {
				nums1[i--] = nums2[k--];
			}
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}

}
