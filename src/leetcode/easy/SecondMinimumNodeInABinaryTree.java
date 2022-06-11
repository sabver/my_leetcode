package leetcode.easy;

import leetcode.util.TreeNode;

public class SecondMinimumNodeInABinaryTree {
	int min = -1;
	int secondMin = 0;

	public int findSecondMinimumValue(TreeNode root) {
		if (root == null) {
			return -1;
		}
		min = root.val;
		helper(root);
		if( secondMin == 0 ) {
			return -1;
		}
		return min != secondMin ? secondMin : -1;
	}

	public void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		int leftVal = root.left != null ? root.left.val : -1;
		if (leftVal != -1) {
			if (leftVal == root.val) {
				helper(root.right);
				helper(root.left);
			} else {
				helper(root.left);
				helper(root.right);
			}
		} else {
			if( root.val > min ) {
                if( secondMin == 0 ){
                    secondMin = root.val;
                } else {
                    secondMin = Math.min(root.val, secondMin);    
                }				
			}
		}
	}
}
