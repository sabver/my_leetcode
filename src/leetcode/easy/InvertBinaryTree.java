package leetcode.easy;

import leetcode.util.TreeNode;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		helper(root);
		return root;
	}

	public void helper(TreeNode root) {
		if( root == null ) {
			return ;
		}
		// exchange
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		helper(root.left);
		helper(root.right);
	}
}
