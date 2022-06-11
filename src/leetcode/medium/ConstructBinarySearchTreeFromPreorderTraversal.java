package leetcode.medium;

import leetcode.util.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {

	public TreeNode bstFromPreorder(int[] preorder) {
		return build(preorder, 0, preorder.length - 1);
	}

	public TreeNode build(int[] preorder, int start, int end) {
		if (start > end) {
			return null;
		}
		int val = preorder[start];
		TreeNode root = new TreeNode(val);
		int rightStart = -1;
		for (int i = start + 1; i <= end; i++) {
			if (preorder[i] > val) {
				rightStart = i;
				break;
			}
		}
		root.left = build(preorder, start + 1, rightStart == -1 ? end : rightStart - 1);
		if (rightStart != -1) {
			root.right = build(preorder, rightStart, end);
		}
		return root;
	}

	public static void main(String[] args) {
		ConstructBinarySearchTreeFromPreorderTraversal c = new ConstructBinarySearchTreeFromPreorderTraversal();
		int[] preorder = new int[] { 8, 5, 1, 7, 10, 12 };
		c.bstFromPreorder(preorder);
	}

}
