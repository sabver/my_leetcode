package leetcode.easy;

import leetcode.util.TreeNode;

public class SubtreeOfAnotherTree {
	String COMA = ",";
	String NULLMARK = "#";
	String BEGIN = "$";

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		String rootCode = encode(root);
		String subRootCode = encode(subRoot);
		System.out.println("rootCode:" + rootCode);
		System.out.println("subRootCode:" + subRootCode);
		return rootCode.indexOf(subRootCode) != -1;
	}

	public String encode(TreeNode root) {
		StringBuffer track = new StringBuffer();
		preorder(root, track);
		return track.toString();
	}

	public void preorder(TreeNode root, StringBuffer track) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			track.append(NULLMARK).append(COMA);
			return;
		}
		track.append(BEGIN).append(root.val).append(COMA);
		preorder(root.left, track);
		preorder(root.right, track);
	}

	public static void main(String[] args) {
		SubtreeOfAnotherTree s = new SubtreeOfAnotherTree();
		TreeNode root = TreeNode.createTreeByArray(new int[] { 12 });
		TreeNode subRoot = TreeNode.createTreeByArray(new int[] { 2 });
		boolean res = s.isSubtree(root, subRoot);
		System.out.println(res);
	}

}
