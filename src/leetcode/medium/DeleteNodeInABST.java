package leetcode.medium;

import leetcode.util.TreeNode;

public class DeleteNodeInABST {
	// 
	public TreeNode deleteNode(TreeNode root, int key) {
		if( root == null ) {
			return null;
		}
		int val = root.val;
		if( key == val ) {
			if( root.left == null ) {
				return root.right;
			}
			if( root.right == null ) {
				return root.left;
			}
			TreeNode rightMin = getMin(root.right);
			root.right = deleteNode(root.right, rightMin.val);
			
			rightMin.left = root.left;
			rightMin.right = root.right;
			root = rightMin;
		} else if( key > val ){
			root.right = deleteNode(root.right, key);
		} else {
			root.left = deleteNode(root.left, key);
		}
		return root;
	}
	
	public TreeNode getMin(TreeNode root) {
		while( root != null && root.left != null ) {
			root = root.left;
		}
		return root;
	}
}
