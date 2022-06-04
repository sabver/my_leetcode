package leetcode.medium;

import leetcode.util.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
	TreeNode res = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		helper(root, p, q);
		return res;
	}

	public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}
		boolean left = helper(root.left, p, q);
		boolean right = helper(root.right, p, q);
		
		if (left && right) {
			res = root;
		}
		if (left || right) {
			if (root.val == p.val) {
				res = p;
			}
			if (root.val == q.val) {
				res = q;
			}
		}
		if( root.val == p.val || root.val == q.val ) {
			return true;
		}
		return left || right;
	}
}
