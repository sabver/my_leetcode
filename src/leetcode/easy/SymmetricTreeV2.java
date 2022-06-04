package leetcode.easy;

import leetcode.util.TreeNode;

public class SymmetricTreeV2 {

	public boolean isSymmetric(TreeNode root) {
		return check(root.left, root.right);
	}

	public boolean check(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}
		return check(left.right, right.left) && check(left.left, right.right);
	}

}
