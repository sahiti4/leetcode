package medium;

import java.util.*;


public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> results = new ArrayList<>();
		if (root == null)
			return results;
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			results.add(list);
		}
		return results;
	}

	public static void main(String[] args) {
	}
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
