package leetcode.medium;

import leetcode.util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		return build(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
	}

	public TreeNode build(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
		if (preStart > preEnd || postStart > postEnd) {
			return null;
		}
		if (preStart == preEnd) {
			return new TreeNode(preorder[preStart]);
		}
		TreeNode root = new TreeNode(preorder[preStart]);

		int nextVal = preorder[preStart + 1];
		int index = -1;
		for (int i = postStart; i <= postEnd; i++) {
			if (nextVal == postorder[i]) {
				index = i;
				break;
			}
		}
		int leftSize = index - postStart + 1;

		root.left = build(preorder, postorder, preStart + 1, preStart + leftSize, postStart, index);
		root.right = build(preorder, postorder, preStart + leftSize + 1, preEnd, index + 1, postEnd - 1);
		return root;
	}

}
