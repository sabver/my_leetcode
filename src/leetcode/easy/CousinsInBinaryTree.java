package leetcode.easy;

import leetcode.util.TreeNode;

public class CousinsInBinaryTree {
	TreeNode xParent;
	TreeNode yParent;
	int xDepth;
	int yDepth;

	public boolean isCousins(TreeNode root, int x, int y) {
		helper(root, null, x, y, 0);
		if (xDepth == yDepth && xParent != null && yParent != null && xParent.val != yParent.val) {
			return true;
		}
		return false;
	}

	public void helper(TreeNode root, TreeNode parent, int x, int y, int level) {
		if (root == null) {
			return;
		}
		if (root.val == x) {
			xParent = parent;
			xDepth = level;
		}
		if (root.val == y) {
			yParent = parent;
			yDepth = level;
		}
		if (root.val == x && root.val == y) {
			return;
		}
		helper(root.left, root, x, y, level + 1);
		helper(root.right, root, x, y, level + 1);
	}

}
