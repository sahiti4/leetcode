package easy;

public class SortedArrayBST {

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null)
			return null;
		TreeNode result = sortedArrayToBST(nums, 0, nums.length - 1);
		return result;
	}

	public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		int mid = (start + end) / 2;
		if (start > end)
			return null;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, end);
		return root;
	}

	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		sortedArrayToBST(nums);
	}

}
