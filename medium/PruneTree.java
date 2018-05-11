package medium;

public class PruneTree {
	public static TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return null;
		if (root.val == 0) {
			TreeNode left = pruneTree(root.left);
			TreeNode right = pruneTree(root.right);
			if (left == null && right == null) {
				root = null;
				return root;
			}
			if (root != null) {
				root.left = left;
				root.right = right;
			}
		} else if (root.val == 1) {
			root.left = pruneTree(root.left);
			root.right = pruneTree(root.right);
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		pruneTree(root);
		System.out.println();
	}

}
