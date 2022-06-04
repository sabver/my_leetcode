package leetcode.medium;

import leetcode.util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalV2 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	public TreeNode helper(int[] preorder, int[] inorder, int startpre, int endpre, int startin, int endin) {
		System.out.println("startpre:" + startpre);
		System.out.println("endpre:" + endpre);
		System.out.println("startin:" + startin);
		System.out.println("endin:" + endin);
		System.out.println();
		if (startpre > endpre || startin > endin) {
			return null;
		}
		int rootVal = preorder[startpre];
		int leftSize = 0, rightSize = 0;
		for (int i = startin; i <= endin; i++) {
			if (inorder[i] == rootVal) {
				leftSize = i - startin;
				rightSize = endin - i;
				break;
			}
		}
		TreeNode root = new TreeNode(rootVal);
		// left tree
		TreeNode leftTree = helper(preorder, inorder, startpre + 1, startpre + leftSize, startin, startin + leftSize - 1);
		TreeNode rightTree = helper(preorder, inorder, endpre - rightSize + 1, endpre, endin - rightSize + 1, endin);
		root.left = leftTree;
		root.right = rightTree;
		return root;
	}
	
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversalV2 v = new ConstructBinaryTreeFromPreorderAndInorderTraversalV2();
		int[] preorder = new int[]{3,9,20,15,7}; 
		int[] inorder = new int[]{9,3,15,20,7}; 
		TreeNode root = v.buildTree(preorder, inorder);
		
	}
	
}
