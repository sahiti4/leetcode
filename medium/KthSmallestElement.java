package medium;


public class KthSmallestElement {

	public static int kthSmallest(TreeNode root, int k) {
		int result = 0;
		int count = 0;
		inorder(root, result, count, k);
		return result;
	}

	public static void inorder(TreeNode root, int result, int count, int k) {
		if (root == null)
			return;
		inorder(root.left, result, count, k);
		if (count == k)
			result = root.val;
		else {
			k++;
		}
		inorder(root.right, result, count, k);
	}

	public static void main(String[] args) {

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
