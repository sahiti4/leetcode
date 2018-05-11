package medium;

public class FlattenBinaryTree {
	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;
		flatten(left);
		flatten(right);
		root.right = left;
		while (root.right != null) {
			root = root.right;
		}
		root.right = right;
		return;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		flatten(root);
		System.out.println(root);
	}
}
