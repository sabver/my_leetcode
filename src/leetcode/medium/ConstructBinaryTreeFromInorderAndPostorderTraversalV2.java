package leetcode.medium;

import leetcode.util.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalV2 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	public TreeNode helper(int[] inorder, int[] postorder, int startin, int endin, int startpost, int endpost) {
		if (startin > endin || startpost > endpost) {
			return null;
		}
		int rootVal = postorder[endpost];
		int leftSize = 0, rootIndex = 0;
		for (int i = startin; i <= endin; i++) {
			if (inorder[i] == rootVal) {
				leftSize = i - startin;
				rootIndex = i;
				break;
			}
		}
		TreeNode root = new TreeNode(rootVal);
		TreeNode leftTree = helper(inorder, postorder, startin, rootIndex - 1, startpost, startpost + leftSize - 1);
		TreeNode rightTree = helper(inorder, postorder, rootIndex + 1, endin, startpost + leftSize, endpost - 1);
		root.left = leftTree;
		root.right = rightTree;
		return root;
	}

	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversalV2 v = new ConstructBinaryTreeFromInorderAndPostorderTraversalV2();
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		int[] postorder = new int[] { 9, 15, 7, 20, 3 };
		TreeNode root = v.buildTree(inorder, postorder);

	}
}
