package leetcode.medium;

import leetcode.util.TreeNode;
import leetcode.util.Util;

public class BinarySearchTreeToGreaterSumTree {
	int sum = 0;

	public TreeNode bstToGst(TreeNode root) {
		inorder(root);
		return root;
	}

	public void inorder(TreeNode root) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			return;
		}
		inorder(root.right);
		sum += root.val;
		System.out.println("sum:" + sum + " root.val:" + root.val);
		root.val = sum;
		inorder(root.left);
	}

	public static void main(String[] args) {
		BinarySearchTreeToGreaterSumTree b = new BinarySearchTreeToGreaterSumTree();
		int[] nums = new int[] { 4, 1, 6, 0, 2, 5, 7, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 3,
				Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 8 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		Util.printBinaryTree(root);
		b.bstToGst(root);
		Util.printBinaryTree(root);
	}
}
