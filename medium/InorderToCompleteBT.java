package medium;

public class InorderToCompleteBT {

	public static TreeNode buildTree(String s, int start, int end) {
		if (start > end)
			return null;
		if (start == end)
			return new TreeNode(s.charAt(start));
		int count = 1;
		int temp = end - start + 1;
		while (temp - count >= 0) {
			temp = temp - count;
			count = count * 2;
		}
		int rootIndex = end - (count / 2) + 1;
		if (temp > count / 2) {
			rootIndex = rootIndex - temp + (count / 2);
		}
		TreeNode root = new TreeNode(s.charAt(rootIndex));
		root.left = buildTree(s, start, rootIndex - 1);
		root.right = buildTree(s, rootIndex + 1, end);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = buildTree("dbeafc", 0, 5);
		System.out.println(root);
	}

}
