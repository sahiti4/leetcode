package medium;

import java.util.*;

public class ZigZagLevelOrder {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<TreeNode> queue = new ArrayList<>();
		List<List<Integer>> results = new ArrayList<>();
		if (root == null)
			return results;
		queue.add(root);
		boolean flag = true;
		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.remove(0);
				list.add(node.val);
				if (node.right != null)
					queue.add(node.right);
				if (node.left != null)
					queue.add(node.left);
			}
			if (flag)
				Collections.reverse(list);
			results.add(list);
			flag = !flag;
		}
		return results;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(1);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(-1);
		root.right.left.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);
		zigzagLevelOrder(root);
	}

}
