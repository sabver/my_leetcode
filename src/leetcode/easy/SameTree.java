package leetcode.easy;

import leetcode.util.*;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return inorder(p, q);
	}

	public boolean inorder(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		boolean leftResult = inorder(p.left, q.left);
		if (leftResult == false) {
			return false;
		}
		return inorder(p.right, q.right);
	}
}
