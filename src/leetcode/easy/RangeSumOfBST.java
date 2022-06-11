package leetcode.easy;

import leetcode.util.TreeNode;

public class RangeSumOfBST {
	int sum = 0;
	int low, high;

	public int rangeSumBST(TreeNode root, int low, int high) {
		this.low = low;
		this.high = high;
		preorder(root);
		return sum;
	}

	public void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.val >= low && root.val <= high) {
			sum += root.val;
		}
		if (root.val >= low) {
			preorder(root.left);
		}
		if (root.val <= high) {
			preorder(root.right);
		}
	}

}
