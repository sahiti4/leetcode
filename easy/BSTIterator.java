package easy;

import java.util.*;

public class BSTIterator {

	Stack<TreeNode> stack = null;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		populateLeft(root);
	}

	public void populateLeft(TreeNode root) {
		if (root != null)
			stack.add(root);
		while (root != null && root.left != null) {
			stack.add(root.left);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode popped = stack.pop();
		populateLeft(popped.right);
		return popped.val;
	}
}
