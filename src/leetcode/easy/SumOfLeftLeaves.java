package leetcode.easy;

import leetcode.util.TreeNode;

public class SumOfLeftLeaves {
	int res = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root, 0);
		return res;
	}

	/**
	 * 
	 * @param root
	 * @param type -1 => left 0 => root 1 => right
	 */
	public void helper(TreeNode root, int type) {
		if (root == null) {
			return;
		}
		if (type == -1 && root.left == null && root.right == null) {
			res += root.val;
		}
		helper(root.left, -1);
		helper(root.right, 1);
	}
}
