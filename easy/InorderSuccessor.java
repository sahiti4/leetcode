package easy;

public class InorderSuccessor {

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		return inorderSuccessor(root, p, null);
	}

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p, TreeNode result) {
		if (root == null)
			return result;
		if (p.val == root.val) {
			TreeNode temp = min(root.right);
			result = temp != null ? temp : result;
			return result;
		}
		if (p.val > root.val) {
			return inorderSuccessor(root.right, p, result);
		}
		if (p.val < root.val) {
			result = root;
			return inorderSuccessor(root.left, p, result);
		}
		return null;
	}

	public static TreeNode min(TreeNode root) {
		TreeNode min = root;
		while (root != null && root.left != null) {
			min = root.left;
		}
		return min;
	}

	public static void main(String[] args) {

	}

}
