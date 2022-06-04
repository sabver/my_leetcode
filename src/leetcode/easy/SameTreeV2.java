package leetcode.easy;

import leetcode.util.TreeNode;

public class SameTreeV2 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if( p == null && q == null ) {
			return true;
		}
		if ((p == null && q != null) || (p != null && q == null) || (p != null && q != null && p.val != q.val)) {
			return false;
		}
		boolean left = isSameTree(p.left, q.left);
		boolean right = isSameTree(p.right, q.right);
		return left && right;
	}
}
