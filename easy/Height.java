package easy;

public class Height {

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int lHeight = 1 + maxDepth(root.left);
		int rHeight = 1 + maxDepth(root.right);
		return Math.max(lHeight, rHeight);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
