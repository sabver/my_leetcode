package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.*;

public class ValidateBinarySearchTree {
	/***
	 * 错的，验证了堆，也不完全
	 * 
	 * @param root
	 * @return
	 */
	// public boolean isValidBST(TreeNode root) {
	// boolean curValid = false;
	// if (root == null) {
	// return true;
	// }
	// if (root.left == null && root.right == null) {
	// return true;
	// } else if (root.left == null && root.right != null) {
	// curValid = root.val < root.right.val;
	// } else if (root.left != null && root.right == null) {
	// curValid = root.val > root.left.val;
	// } else {
	// curValid = (root.val < root.right.val) && (root.val > root.left.val);
	// }
	// return curValid && isValidBST(root.left) && isValidBST(root.right);
	// }

	public boolean isValidBST(TreeNode root) {
		return inorder(new ArrayList<Integer>(), root);
	}

	public boolean inorder(List<Integer> inOrderList, TreeNode node) {
		if (node == null) {
			return true;
		}
		boolean leftResult = inorder(inOrderList, node.left);
		if (leftResult == false) {
			return false;
		}
		inOrderList.add(node.val);
		int size = inOrderList.size();
		if (size > 1) {
			// 如果inOrderList里面的元素不是严格递增的就是有问题的
			if (inOrderList.get(size - 1) <= inOrderList.get(size - 2)) {
				return false;
			}
		}
		boolean rightResult = inorder(inOrderList, node.right);
		if (rightResult == false) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree s = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(s.isValidBST(root));
	}
    public boolean isValidBSTLeetCode(TreeNode root) {
        return isValidBSTLeetCode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBSTLeetCode(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBSTLeetCode(root.left, minVal, root.val) && isValidBSTLeetCode(root.right, root.val, maxVal);
    }	
}
