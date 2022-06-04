package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class RecoverBinarySearchTree {
	// 记录中序的结果
	List<TreeNode> inorderList = new ArrayList<>();

	public void recoverTree(TreeNode root) {
		inorder(root);
		// 判断哪两个元素的顺序有问题
		TreeNode first = null;
		TreeNode second = null;
		TreeNode pre = null;
		for (int i = 0; i < inorderList.size(); i++) {
			TreeNode node = inorderList.get(i);
			if (pre != null && node != null && pre.val > node.val) {
				if (first == null) {
					first = pre;
                    second = node;
				} else {
					second = node;
					break;
				}
			}
			pre = node;
		}
		if (first != null && second != null) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
		}
	}

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		inorderList.add(root);
		inorder(root.right);
	}
}
