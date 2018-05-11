package easy;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null)
			return right == null;
		if (right == null)
			return left == null;
		if (left.val == right.val)
			return isSymmetric(left.right, right.left) && isSymmetric(right.right, left.left);
		return false;
	}

	public static void main(String[] args) {

	}

}
