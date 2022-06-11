package leetcode.easy;

import leetcode.util.TreeNode;

public class LeafSimilarTrees {
	String SEP = ",";

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		StringBuffer track1 = new StringBuffer();
		StringBuffer track2 = new StringBuffer();
		preorder(root1, track1);
		preorder(root2, track2);
		return track1.toString().equals(track2.toString());
	}

	public void preorder(TreeNode root, StringBuffer track) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			track.append(root.val).append(SEP);
		}
		preorder(root.left, track);
		preorder(root.right, track);
	}

}
