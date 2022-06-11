package leetcode.easy;

import leetcode.util.TreeNode;
import leetcode.util.Util;

public class IncreasingOrderSearchTree {
	TreeNode prev;
	TreeNode res;

	public TreeNode increasingBST(TreeNode root) {
		inorder(root);
		return res;
	}

	public void inorder(TreeNode root) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			return;
		}
		inorder(root.left);
		if (prev != null) {
			prev.left = null;
			prev.right = root;
			root.left = null;
		} else {
			res = root;
		}
		prev = root;
		inorder(root.right);
	}

	public static void main(String args[]) {
		IncreasingOrderSearchTree i = new IncreasingOrderSearchTree();
		int[] nums = new int[] { 2, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 3 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		TreeNode res = i.increasingBST(root);
		Util.printBinaryTree(res);
	}

}
