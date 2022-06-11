package leetcode.easy;

import leetcode.util.TreeNode;

public class ConstructStringFromBinaryTree {

	String LEFT = "(";
	String RIGHT = ")";

	public String tree2str(TreeNode root) {
		StringBuffer track = new StringBuffer();
		preorder(root, track);
		track.deleteCharAt(track.length() - 1);
		track.deleteCharAt(0);
		return track.toString();
	}

	public void preorder(TreeNode root, StringBuffer track) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			track.append(LEFT).append(RIGHT);
			return;
		}
		track.append(LEFT);
		track.append(root.val);
		if( root.left == null && root.right == null ) {
			track.append(RIGHT);
			return ;
		}
		preorder(root.left, track);
		if( root.right != null ) {
			preorder(root.right, track);
		}
		
		track.append(RIGHT);
	}

	public static void main(String args[]) {
		ConstructStringFromBinaryTree s = new ConstructStringFromBinaryTree();
		int[] nums = new int[] { 1, 2, 3, 4 };
//		int[] nums = new int[] { 1, 2, 3, Integer.MIN_VALUE, 4 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		String res = s.tree2str(root);
		System.out.println(res);
	}

}
