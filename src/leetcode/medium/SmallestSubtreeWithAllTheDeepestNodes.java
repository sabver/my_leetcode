package leetcode.medium;

import leetcode.util.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

	class Result {
		TreeNode node;
		int maxDepth;

		public Result(TreeNode node, int maxDepth) {
			this.node = node;
			this.maxDepth = maxDepth;
		}
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		Result res = helper(root);
		return res.node;
	}

	public Result helper(TreeNode root) {
		if (root == null) {
			return new Result(root, 0);
		}
		Result left = helper(root.left);
		Result right = helper(root.right);

		if (left.maxDepth == right.maxDepth) {
			return new Result(root, left.maxDepth + 1);
		}

		Result res = left.maxDepth > right.maxDepth ? left : right;
		res.maxDepth++;
		return res;
	}

}
