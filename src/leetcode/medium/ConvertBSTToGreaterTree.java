package leetcode.medium;

import leetcode.util.TreeNode;

public class ConvertBSTToGreaterTree {
	int sum = Integer.MIN_VALUE;

	public TreeNode convertBST(TreeNode root) {
		inorder(root);
		return root;
	}

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.right);
		if (sum != Integer.MIN_VALUE) {
			sum += root.val;
		} else {
			sum = root.val;
		}
		root.val = sum;
		inorder(root.left);
	}

}
