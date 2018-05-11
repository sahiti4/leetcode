package hard;

import java.util.*;

public class SerializeandDeserialize {

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		String data = "";
		if (root == null)
			return data;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		data += root.val;
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr == null) {
				data += ",";
				data += "x";
			}
			queue.add(curr.left);
			queue.add(curr.right);
		}
		return data;
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		String[] elements = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
		TreeNode curr = root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(curr);
		int i = 1;
		while (i < elements.length) {
			curr = queue.poll();
			String left = elements[i++];
			String right = elements[i++];
			if (!left.equals("x")) {
				curr.left = new TreeNode(Integer.parseInt(left));
				queue.add(curr.left);
			}
			if (!right.equals("x")) {
				curr.right = new TreeNode(Integer.parseInt(right));
				queue.add(curr.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(serialize(root));
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
