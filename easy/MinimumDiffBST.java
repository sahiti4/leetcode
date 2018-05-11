package easy;

import java.util.*;

public class MinimumDiffBST {

	public static int minDiffInBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root != null)
			list.add(root.val);
		inorder(root, list);
		Collections.sort(list);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			min = Math.min(list.get(i) - list.get(i - 1), min);
		}
		return min;
	}

	public static void inorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		if (root.left != null) {
			inorder(root.left, list);
			list.add(root.left.val);
		}
		if (root.right != null) {
			inorder(root.right, list);
			list.add(root.right.val);
		}
		return;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(90);
		root.left = new TreeNode(69);
		root.left.right = new TreeNode(89);
		root.left.left = new TreeNode(49);
		root.left.left.right = new TreeNode(52);
		System.out.println(minDiffInBST(root));
	}
}
