package easy;

import java.util.Arrays;

public class ConstructBT {

//	public TreeNode buildTree(int[] inorder, int[] postorder) {
//		TreeNode root = null;
//
//		return root;
//	}
//
//	public TreeNode buildTree(int[] inorder, int[] postorder, int i) {
//		if (inorder.length == 0)
//			return null;
//		if (i == 0 && inorder.length > 0) {
//			return new TreeNode(inorder[0]);
//		}
//		int temp = search(postorder, inorder[i + 1]);
//		TreeNode root = new TreeNode(inorder[i + 1]);
////		root.left = buildTree();
//		int[] inTemp = Arrays.copyOfRange(inorder, i, temp);
//		int[] postTemp = Arrays.copyOfRange(postorder, i, temp);
//
//		return null;
//	}

	public int search(int[] temp, int target) {
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == target)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {

	}
}
