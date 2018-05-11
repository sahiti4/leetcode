package hard;

public class MaxPathSum {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPathSum1(root);
		return max;
	}

	public int maxPathSum1(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		int left = maxPathSum1(root.left);
		int right = maxPathSum1(root.right);
		int maxPath = Math.max(left, right);
		if (maxPath != Integer.MIN_VALUE)
			maxPath = Math.max(root.val, root.val + maxPath);
		else
			maxPath = root.val;
		max = Math.max(maxPath, max);
		if (left != Integer.MIN_VALUE && right != Integer.MIN_VALUE)
			max = Math.max(max, right + left + root.val);
		return maxPath;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		 root.left = new TreeNode(3);
		 root.right = new TreeNode(-3);
		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);
		// root.left.right.left = new TreeNode(-9);
		// root.right = new TreeNode(-3);
		// root.right.left = new TreeNode(6);
		// // root.right.left.left = new TreeNode(8);
		// root.right.left.right = new TreeNode(7);
		MaxPathSum obj = new MaxPathSum();
		System.out.println(obj.maxPathSum(root));
		System.out.println(obj.max);
	}

}
