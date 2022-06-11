package leetcode.medium;

import leetcode.util.TreeNode;

public class DistributeCoinsInBinaryTree {

	int res = 0;

	public int distributeCoins(TreeNode root) {
		getRest(root);
		return res;
	}

	public int getRest(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getRest(root.left);
		int right = getRest(root.right);

		res += Math.abs(left) + Math.abs(right) + root.val - 1;

		return left + right + root.val - 1;

	}

}
