package leetcode.medium;

import leetcode.util.TreeNode;

public class ValidateBinarySearchTreeV2 {
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) {
			return true;
		}
		boolean isLeftValidate = helper(root.left, min, root);
		boolean isValidate = true;
		// 中序
		if ((min != null && root.val <= min.val) || (max != null && root.val >= max.val)) {
			isValidate = false;
		}
		boolean isRightValidate = helper(root.right, root, max);
		return isValidate && isLeftValidate && isRightValidate;
	}

}
