package leetcode.medium;

import leetcode.util.TreeNode;

public class BinaryTreePruning {

	public TreeNode pruneTree(TreeNode root) {
		int count = helper(root);
		if( count == 0 ) {
			return null;
		}
		return root;
	}

	public int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		if (left == 0) {
			root.left = null;
		}
		if (right == 0) {
			root.right = null;
		}

		int count = left + right;
		if (root.val == 1) {
			count++;
		}

		return count;
	}
}
