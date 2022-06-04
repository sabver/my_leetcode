package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
		}
		helper(result, root);
		return result;
	}

	public void helper(List<Integer> result, TreeNode node) {
		if (node == null) {
			return;
		}
		helper(result, node.left);
		result.add(node.val);
		helper(result, node.right);
	}

	public static void main(String[] args) {
		BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> result = bt.inorderTraversal(root);
		for(Integer i : result) {
			System.out.println(i);
		}

	}
}
