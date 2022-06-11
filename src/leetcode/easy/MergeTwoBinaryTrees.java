package leetcode.easy;

import leetcode.util.TreeNode;

public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}
		int root1Val = 0, root2Val = 0;
		if (root1 != null) {
			root1Val = root1.val;
		}
		if (root2 != null) {
			root2Val = root2.val;
		}
		TreeNode root = new TreeNode(root1Val + root2Val);
		root.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
		root.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
		return root;
	}
}
